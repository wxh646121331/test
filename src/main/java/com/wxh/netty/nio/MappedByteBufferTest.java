package com.wxh.netty.nio;

import org.junit.Test;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author wuxinhong
 * @date 2021/2/5 8:06 下午
 * MappedByteBuffer 可以让文件直接在内存（堆外内存）修改，操作系统不需要拷贝一次
 */
public class MappedByteBufferTest {
    @Test
    public void test() throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile("1.txt", "rw");

        FileChannel channel = randomAccessFile.getChannel();
        /**
         * 参数1：使用读写模式
         * 参数2：0：可以直接修改的起始位置
         * 参数3：5：是映射到内存的大小，即将1.txt的多少个字节映射到内存
         * 可以直接修改的范围是 0~5
         */
        MappedByteBuffer mappedByteBuffer = channel.map(FileChannel.MapMode.READ_WRITE, 0, 5);
        mappedByteBuffer.put(0, (byte)8);
        mappedByteBuffer.put(4, (byte)'H');
//        mappedByteBuffer.put(5, (byte)'Y'); //IndexOutOfBoundsException
        randomAccessFile.close();
    }
}
