package com.wxh.netty.http;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;

import java.net.URI;

/**
 * @author wuxinhong
 * @date 2021/4/12 4:00 下午
 */
public class TestHttpServerHandler extends SimpleChannelInboundHandler<HttpObject> {
    // 读取客户端数据
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, HttpObject msg) throws Exception {
        // 判断msg是不是httpRequest请求
        if(msg instanceof HttpRequest){
            System.out.println("msg 类型=" + msg.getClass());
            System.out.println("客户端地址" + ctx.channel().remoteAddress());
            // 获取URI，过滤特定资源
            HttpRequest httpRequest = (HttpRequest) msg;
            URI uri = new URI(httpRequest.getUri());
            if("/favicon.ico".equals(uri.getPath())){
                System.out.println("请求了/favicon.ico，不做响应");
                return;
            }
            ByteBuf content = Unpooled.copiedBuffer("hello, 我是服务器", CharsetUtil.UTF_8);
            FullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK, content);
            response.headers().set(HttpHeaderNames.CONTENT_TYPE, "text/plain");
            response.headers().set(HttpHeaderNames.CONTENT_LENGTH, content.readableBytes());
            ctx.writeAndFlush(response);
        }
    }
}
