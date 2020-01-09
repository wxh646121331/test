package com.wxh.design.singleton;

/**
 * @description:
 * @author: wuxinhong
 * @date: 2019/11/19
 * @time: 上午1:15
 * 静态内部类的特点：
 * 1. 外部类装载时不会触发静态内部类装载
 * 2. 类的装载是线程安全的
 */
public class InterClass {
    private InterClass(){

    }
    private static class InterInstance{
        private static InterClass instance = new InterClass();
    }

    public static InterClass getInstance(){
        return InterInstance.instance;
    }
}
