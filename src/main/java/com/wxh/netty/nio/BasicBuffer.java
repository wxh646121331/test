package com.wxh.netty.nio;

import org.junit.Test;
import scala.util.control.Exception;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

/**
 * @author wuxinhong
 * @date 2021/1/26 4:30 下午
 */
public class BasicBuffer {
    @Test
    public void testIntBuffer() {
        // 创建一个Buffer，大小为5，即可以存放5个int
        IntBuffer intBuffer = IntBuffer.allocate(5);
        // 向buffer中存放数据
        for(int i=0; i<intBuffer.capacity(); i++){
            intBuffer.put(i * 2);
        }
        // 读取数据，将buffer转换，读写切换
        intBuffer.flip();
        intBuffer.limit(3);
        while (intBuffer.hasRemaining()){
            System.out.println(intBuffer.get());
        }

        intBuffer.flip();
        intBuffer.limit(5);
        intBuffer.put(10);
        intBuffer.put(11);
        intBuffer.put(13);
        intBuffer.flip();
        intBuffer.limit(5);
        while (intBuffer.hasRemaining()){
            System.out.println(intBuffer.get());
        }
    }

    @Test
    public void testByteBufferPutGet(){
        ByteBuffer byteBuffer = ByteBuffer.allocate(64);
        byteBuffer.putInt(100);
        byteBuffer.putLong(9L);
        byteBuffer.putChar('好');
        byteBuffer.putShort((short)1);
        byteBuffer.flip();
        System.out.println(byteBuffer.getInt());
        System.out.println(byteBuffer.getLong());
        System.out.println(byteBuffer.getChar());
        System.out.println(byteBuffer.getShort());
    }

    @Test
    public void testReadonlyBuffer(){
        ByteBuffer byteBuffer = ByteBuffer.allocate(64);
        for(int i=0; i < 64; i++){
            byteBuffer.put((byte) i);
        }
        byteBuffer.flip();
        ByteBuffer readOnlyBuffer = byteBuffer.asReadOnlyBuffer();

        while (readOnlyBuffer.hasRemaining()){
            System.out.println(readOnlyBuffer.get());
        }
//        readOnlyBuffer.put((byte)1); //ReadOnlyBufferException
    }
}
