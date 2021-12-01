package com.wxh.juc.ordering;

/**
 * @author wuxinhong
 * @date 2021/8/23 11:03 下午
 */
public class NoVisbility {
    private static boolean ready = false;
    private static int number;

    public static class ReaderThread extends Thread{
        @Override
        public void run(){
            while (!ready){
                Thread.yield();
            }
            System.out.println(number);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t = new ReaderThread();
        t.start();
        number = 42;
        ready = true;
        t.join();
    }
}
