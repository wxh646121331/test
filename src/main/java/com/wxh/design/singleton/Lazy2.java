package com.wxh.design.singleton;

/**
 * @description:
 * @author: wuxinhong
 * @date: 2019/11/19
 * @time: 上午12:18
 */
public class Lazy2 {
    private static Lazy2 instance;
    static {
        instance = new Lazy2();
    }
    private Lazy2(){

    }

    public static Lazy2 getInstance(){
        return instance;
    }
}
