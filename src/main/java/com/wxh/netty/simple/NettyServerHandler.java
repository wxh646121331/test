package com.wxh.netty.simple;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;
import org.ujmp.core.util.DateUtil;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author wuxinhong
 * @date 2021/4/4 10:35 下午
 */
public class NettyServerHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        // 非常耗时的业务 -> 异步执行 -> 提交该channel对应的NIOEventLoop的TaskQueue中
        // 用户程序自定义的普通任务
        ctx.channel().eventLoop().execute(() -> {
            try {
                Thread.sleep(3 * 1000);
                System.out.println("休眠3秒");
                ctx.writeAndFlush(Unpooled.copiedBuffer("hello，客户端~(>^w^<)喵2", CharsetUtil.UTF_8));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        ctx.channel().eventLoop().execute(() -> {
            try {
                Thread.sleep(5 * 1000);
                System.out.println("休眠5秒");
                ctx.writeAndFlush(Unpooled.copiedBuffer("hello，客户端~(>^w^<)喵3", CharsetUtil.UTF_8));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        ctx.channel().eventLoop().schedule(() -> {
            try {
                Thread.sleep(5 * 1000);
                ctx.writeAndFlush(Unpooled.copiedBuffer("hello，客户端~(>^w^<)喵4", CharsetUtil.UTF_8));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, 5, TimeUnit.SECONDS);
        System.out.println("go on ...");
        System.out.println("server ctx = " + ctx);
        // 将msg转成一个ByteBuf
        ByteBuf buf = (ByteBuf) msg;
        System.out.println("客户端发送消息是：" + buf.toString(CharsetUtil.UTF_8));
        System.out.println("客户端地址：" + ctx.channel().remoteAddress());
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx){
        ctx.writeAndFlush(Unpooled.copiedBuffer("hello，客户端~(>^w^<)喵1", CharsetUtil.UTF_8));
//        ctx.close();
    }

    public static void main(String[] args) {
        long cur = System.currentTimeMillis();
        Date date = new Date(cur * 2);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(format.format(date));
    }
}
