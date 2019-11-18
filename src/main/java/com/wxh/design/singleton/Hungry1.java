package com.wxh.design.singleton;

/**
 * @description:
 * @author: wuxinhong
 * @date: 2019/11/19
 * @time: 上午12:21
 */
public class Hungry1 {
    private static Hungry1 instance;

    private Hungry1(){

    }

    public static Hungry1 getInstance(){
        if(null == instance){
            instance = new Hungry1();
        }
        return instance;
    }
}
