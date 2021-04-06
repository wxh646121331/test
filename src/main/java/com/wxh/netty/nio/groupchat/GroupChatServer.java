package com.wxh.netty.nio.groupchat;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;

/**
 * @author wuxinhong
 * @date 2021/3/31 4:29 下午
 */
public class GroupChatServer {
    // 定义属性
    private Selector selector;

    private ServerSocketChannel listenChannel;

    private static final int port = 6667;

    public GroupChatServer(){
        try{
            // 得到选择器
            selector = Selector.open();
            // ServerSocketChannel
            listenChannel = ServerSocketChannel.open();
            // 绑定端口
            listenChannel.socket().bind(new InetSocketAddress(port));
            // 设置非阻塞模式
            listenChannel.configureBlocking(false);
            // 注册到selector
            listenChannel.register(selector, SelectionKey.OP_ACCEPT);
        }catch (IOException e){
            e.printStackTrace();
        }
    }


    public void listen(){
        try{
            while (true){
                int count = selector.select();
                if(count > 0){
                    Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                    while (iterator.hasNext()){
                        SelectionKey key = iterator.next();
                        if(key.isAcceptable()){
                            SocketChannel sc = listenChannel.accept();
                            sc.configureBlocking(false);
                            sc.register(selector, SelectionKey.OP_READ);
                            // 提示
                            System.out.println(sc.getRemoteAddress() + "上线");
                        }
                        if(key.isReadable()){
                            readData(key);
                        }
                    }
                    // 移除当前key，防止重复处理
                    iterator.remove();
                }else {
//                    System.out.println("等待....");
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    // 读取客户端消息
    private void readData(SelectionKey key){
        // 定义一个SocketChannel
        SocketChannel channel = null;
        try{
            channel = (SocketChannel) key.channel();
            //创建buffer
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            int count = channel.read(buffer);
            // 根据count的值做处理
            if(count > 0){
                // 把缓存区的数据转成字符串
                String msg = new String(buffer.array());
                System.out.println("from client: " + msg);
                // 向其它客户端转发消息
                sendInfoToOther(msg, channel);
            }
        }catch (IOException e){
            try {
                System.out.println(channel.getRemoteAddress() + "离线了...");
                // 取消注册
                key.cancel();
                // 关闭通道
                channel.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }

    private void sendInfoToOther(String msg, SocketChannel self){
        System.out.println("服务器转发消息中...");
        //遍历所有注册到selector上的SocketChannel，并排除self
        for(SelectionKey key : selector.keys()){
            Channel targetChannel = key.channel();
            if(targetChannel == self){
                continue;
            }
            if(!(targetChannel instanceof SocketChannel)){
                continue;
            }

            SocketChannel dest = (SocketChannel)targetChannel;
            ByteBuffer buffer = ByteBuffer.wrap(msg.getBytes());
            try {
                dest.write(buffer);
            } catch (IOException e) {
                try {
                    System.out.println(dest.getRemoteAddress() + "离线了...");
                    // 取消注册
                    key.cancel();
                    // 关闭通道
                    dest.close();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        // 创建一个服务器对象
        GroupChatServer groupChatServer = new GroupChatServer();
        groupChatServer.listen();
    }
}
