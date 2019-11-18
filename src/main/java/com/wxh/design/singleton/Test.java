package com.wxh.design.singleton;

/**
 * @description:
 * @author: wuxinhong
 * @date: 2019/11/19
 * @time: 上午12:12
 */
public class Test {
    public static void main(String[] args) {
        Lazy1 ins1 = Lazy1.getInstance();
        Lazy1 ins2 = Lazy1.getInstance();
        System.out.println(ins1==ins2);
        Lazy2 ins3 = Lazy2.getInstance();
        Lazy2 ins4 = Lazy2.getInstance();
        System.out.println(ins3==ins4);

        Hungry1 h1 = Hungry1.getInstance();
        Hungry1 h2 = Hungry1.getInstance();
        System.out.println(h1==h2);
    }
}
