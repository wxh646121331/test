package com.wxh.jvm;

/**
 * @description:
 * @author: wuxinhong
 * @date: 2020/5/26
 * @time: 下午11:07
 * Copyright (C) 2020 MTDP
 * All rights reserved
 */
public class ClassLoadTest {
    public static void main(String[] args) {
        ClassLoader classLoader = ClassLoadTest.class.getClassLoader();
        System.out.println(classLoader);
        ClassLoader classLoader1 = classLoader.getParent();
        System.out.println(classLoader1);
        ClassLoader classLoader2 = classLoader1.getParent();
        System.out.println(classLoader2);
        System.out.println(String.class.getClassLoader());
    }
}
