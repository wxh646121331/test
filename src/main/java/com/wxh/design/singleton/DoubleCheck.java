package com.wxh.design.singleton;

/**
 * @description:
 * @author: wuxinhong
 * @date: 2019/11/19
 * @time: 上午12:27
 */
public class DoubleCheck {
    private static DoubleCheck instance;

    private DoubleCheck(){

    }

    public synchronized static DoubleCheck getInstance(){
        if(null == instance){
            synchronized (DoubleCheck.class){
                if(null == instance){
                    instance = new DoubleCheck();
                }
            }
        }
        return instance;
    }
}
