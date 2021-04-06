package com.wxh.netty.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * @author wuxinhong
 * @date 2021/3/30 10:59 下午
 */
public class NIOClient {
    public static void main(String[] args) throws IOException {
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.configureBlocking(false);
        InetSocketAddress socketAddress = new InetSocketAddress("127.0.0.1", 6666);
        // 连接服务器
        if (!socketChannel.connect(socketAddress)) {
            while (!socketChannel.finishConnect()) {
                System.out.println("因为连接需要时间，客户端不会阻塞，可以做其它工作...");
            }
        }
        // 如果连接成功，就发送数据
        String str = "hello, world!";
        ByteBuffer buffer = ByteBuffer.wrap(str.getBytes());
        // 将buffer数据写入channel
        socketChannel.write(buffer);
        System.in.read();
    }
}
