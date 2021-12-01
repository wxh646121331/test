package com.wxh.juc.visibility;

import java.util.concurrent.TimeUnit;

/**
 * @author wuxinhong
 * @date 2021/4/22 8:00 下午
 */
public class HelloVolatile01 {
    private  static volatile boolean running = true;
    public static void main(String[] args) throws InterruptedException {
        new Thread(HelloVolatile01::m, "t1").start();

        TimeUnit.SECONDS.sleep(1L);

        running = false;
    }

    private static void m(){
        System.out.println("m start");
        while (running){

        }
        System.out.println("m end");
    }
}
