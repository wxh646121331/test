package com.wxh.design.singleton;

/**
 * @description:
 * @author: wuxinhong
 * @date: 2019/11/19
 * @time: 上午12:05
 */
public class Lazy1 {
    public static Lazy1 instance = new Lazy1();
    private Lazy1(){

    }
    public static Lazy1 getInstance(){
        return instance;
    }
}
