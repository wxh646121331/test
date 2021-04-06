package com.wxh.netty.nio;

import org.junit.Test;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author wuxinhong
 * @date 2021/2/4 9:05 下午
 */
public class NioFileChannel {
    @Test
    public void testWriteChannel() throws IOException {
        String str = "hello, world";
        // 创建一个输出流 -> channel
        FileOutputStream fileOutputStream = new FileOutputStream("file01.txt");
        FileChannel fileChannel = fileOutputStream.getChannel();
        // 创建一个缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        // 将str放入byteBuffer
        byteBuffer.put(str.getBytes());
        // 将byteBuffer反转
        byteBuffer.flip();
        fileChannel.write(byteBuffer);
        fileOutputStream.close();
    }

    @Test
    public void testReadChannel() throws IOException {
        File file = new File("/Users/wuxinhong/test/file02.txt");
        FileInputStream fileInputStream = new FileInputStream(file);
        FileChannel fileChannel = fileInputStream.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate((int)file.length());
        fileChannel.read(byteBuffer);
        byteBuffer.flip();
        System.out.println(new String(byteBuffer.array()));
    }

    /**
     * 使用一个buffer完成文件读写
     * @throws IOException
     */
    @Test
    public void testCopyChannel() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("1.txt");
        FileChannel fileChannel1 = fileInputStream.getChannel();
        FileOutputStream fileOutputStream = new FileOutputStream("2.txt");
        FileChannel fileChannel2 = fileOutputStream.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(5);
        while (true){
            byteBuffer.clear();
            int read = fileChannel1.read(byteBuffer);
            if(-1 == read){
                break;
            }
            byteBuffer.flip();
            fileChannel2.write(byteBuffer);
        }
    }

    @Test
    public void testTransferFrom() throws IOException {
        // 创建相关流
        FileInputStream fileInputStream = new FileInputStream("/Users/wuxinhong/test/a.png");
        FileOutputStream fileOutputStream = new FileOutputStream("/Users/wuxinhong/test/b.png");

        FileChannel sourceChannel = fileInputStream.getChannel();
        FileChannel destChannel = fileOutputStream.getChannel();

        destChannel.transferFrom(sourceChannel, 0, sourceChannel.size());
        sourceChannel.close();
        destChannel.close();
        fileInputStream.close();
        fileOutputStream.close();
    }

    @Test
    public void testTransferTo() throws IOException {
        // 创建相关流
        FileInputStream fileInputStream = new FileInputStream("/Users/wuxinhong/test/a.png");
        FileOutputStream fileOutputStream = new FileOutputStream("/Users/wuxinhong/test/c.png");

        FileChannel sourceChannel = fileInputStream.getChannel();
        FileChannel destChannel = fileOutputStream.getChannel();

        sourceChannel.transferTo(0, sourceChannel.size(), destChannel);
        sourceChannel.close();
        destChannel.close();
        fileInputStream.close();
        fileOutputStream.close();
    }
}
