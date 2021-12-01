package com.wxh.juc.ordering;

import java.util.concurrent.CountDownLatch;

/**
 * @author wuxinhong
 * @date 2021/8/23 5:31 下午
 */
public class Disorder {
    private static int x = 0, y = 0;
    private static int a = 0, b = 0;

    public static void main(String[] args) throws InterruptedException {
        for (long i=0; i<Long.MAX_VALUE; i++){
            x = 0;
            y = 0;
            a = 0;
            b = 0;
            CountDownLatch latch = new CountDownLatch(2);
            Thread one = new Thread(() ->{
                a = 1;
                x = b;
                latch.countDown();
            });

            Thread two = new Thread(() -> {
                b = 1;
                y = a;
                latch.countDown();
            });

            one.start();
            two.start();
            latch.await();
            if(x == 0 && y == 0){
                String result = String.format("执行第%d次，x=0,y=0", i);
                System.out.println(result);
                break;
            }
        }
    }
}
