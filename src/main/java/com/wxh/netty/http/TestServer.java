package com.wxh.netty.http;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @author wuxinhong
 * @date 2021/4/12 4:00 下午
 */
public class TestServer {
    public static void main(String[] args) {
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try{
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class)
                    .childHandler(new TestServerInitializer());
            ChannelFuture cf = serverBootstrap.bind(6668).sync();
            cf.channel().closeFuture().sync();
        }catch (Exception e){
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}
