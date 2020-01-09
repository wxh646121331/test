package com.wxh.design.singleton;

/**
 * @description:
 * @author: wuxinhong
 * @date: 2019/11/19
 * @time: 上午1:19
 */
public class Hungry3 {
    private static Hungry3 instance;

    private Hungry3(){
    }
    /**
     * 有并发问题
     * @return
     */
    public synchronized static Hungry3 getInstance1(){
        if(null == instance){
            synchronized (Hungry3.class){
                instance = new Hungry3();
            }
        }
        return instance;
    }
}
