package com.wxh.netty.nio;

import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Arrays;

/**
 * @author wuxinhong
 * @date 2021/2/6 11:18 下午
 * Scattering: 将数据写入到buffer时，可以采用buffer数组，依次写入
 * Gathering: 从buffer读取数据时，可以采用buffer数据，依次读
 */
public class ScatteringAndGatheringTest {

    @Test
    public void scatteringTest() throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        InetSocketAddress inetSocketAddress = new InetSocketAddress(7000);
        // 绑定端口到socket，并启动
        serverSocketChannel.socket().bind(inetSocketAddress);
        //创建buffer数据
        ByteBuffer[] byteBuffers = new ByteBuffer[2];
        byteBuffers[0] = ByteBuffer.allocate(5);
        byteBuffers[1] = ByteBuffer.allocate(3);

        // 等待客户端连接
        SocketChannel socketChannel = serverSocketChannel.accept();
        int msgLength = 8;
        while (true){
            int byteRead = 0;
            while (byteRead < msgLength){
                long l = socketChannel.read(byteBuffers);
                byteRead += l;
                System.out.println("byteRead=" + byteRead);
                // 使用流打印，查看当前buffer的position和limt
                Arrays.asList(byteBuffers).stream().map(x -> "position:"+x.position()
                        +",limit:"+x.limit()).forEach(System.out::println);
                Arrays.asList(byteBuffers).forEach(x -> x.flip());

                long byteWrite = 0;
                ByteBuffer byteBuffer = ByteBuffer.allocate(10);
                byteBuffer.put("你好：".getBytes());
                byteBuffer.flip();
                socketChannel.write(byteBuffer);
                while (byteWrite < l){
                    byteWrite += socketChannel.write(byteBuffers);
                }
                Arrays.asList(byteBuffers).forEach(x -> x.clear());
                System.out.println("byteRead:" + byteRead);
                System.out.println("byteWrite:" + byteWrite);
            }
        }
    }

    @Test
    public void gatheringTest(){

    }
}
