package com.wxh.netty.nio;

import java.nio.IntBuffer;

/**
 * @author wuxinhong
 * @date 2021/1/26 4:30 下午
 */
public class BasicBuffer {
    public static void main(String[] args) {
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
}
