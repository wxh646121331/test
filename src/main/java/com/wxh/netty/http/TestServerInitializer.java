package com.wxh.netty.http;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;

/**
 * @author wuxinhong
 * @date 2021/4/12 4:01 下午
 */
public class TestServerInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel sc) throws Exception {
        // 向管道加入处理器
        // 得到管理
        ChannelPipeline pipeline = sc.pipeline();
        // 加入一个netty提供的httpServerCode => [coder - decoder]
        pipeline.addLast("MyHttpServerDesc", new HttpServerCodec());
        // 增加一个自定义的处理器
        pipeline.addLast("MyTestHttpServerHandler", new TestHttpServerHandler());

        System.out.println(1);

    }
}
