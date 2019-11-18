package com.wxh.design.singleton;

/**
 * @description:
 * @author: wuxinhong
 * @date: 2019/11/19
 * @time: 上午12:23
 */
public class Hungry2 {
    private static Hungry2 instance;

    private Hungry2(){

    }

    /**
     * 效率低
     * @return
     */
    public synchronized static Hungry2 getInstance(){
        if(null == instance){
            instance = new Hungry2();
        }
        return instance;
    }

    /**
     * 有并发问题
     * @return
     */
    public synchronized static Hungry2 getInstance1(){
        if(null == instance){
            synchronized (Hungry2.class){
                instance = new Hungry2();
            }
        }
        return instance;
    }
}
