package com.wxh.netty.simple;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @author wuxinhong
 * @date 2021/4/4 10:24 下午
 */
public class NettyServer {
    public static void main(String[] args) throws InterruptedException {
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);

        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try{
            // 创建服务器端的启动对象，配置参数
            ServerBootstrap bootstrap = new ServerBootstrap();
            // 使用链式编程来进行设置
            bootstrap.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG, 128)
                    .childOption(ChannelOption.SO_KEEPALIVE, true)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            //可以使用一个集合管理 SocketChannel，再推送消息时，可以将业务加入到各个channel对应的NIOEventLoop的taskQueue

                            // 给pipeline 设置处理器
                            socketChannel.pipeline().addLast(new NettyServerHandler());
                        }
                    });
            System.out.println("......server is ready...");
            // 启动服务器（并绑定端口）
            ChannelFuture cf = bootstrap.bind(6668).sync();
            cf.addListener(future -> {
                if(future.isSuccess()){
                    System.out.println("绑定端口6668成功");
                }else {
                    System.out.println("绑定端口6668失败");
                }
            });
            // 对关闭通道进行监听
            cf.channel().closeFuture().sync();
        }finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }

    }
}
