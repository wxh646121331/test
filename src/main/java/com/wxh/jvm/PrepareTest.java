package com.wxh.jvm;

/**
 * @description:
 * @author: wuxinhong
 * @date: 2020/5/25
 * @time: 下午8:34
 * Copyright (C) 2020 MTDP
 * All rights reserved
 */
public class PrepareTest {
    /**
     * 准备阶段：为类变量分配内存并且设置该类变量的默认初始值，即零值
     * prepare 阶段：a = 0，initial 阶段： a=1
     */
    private static int a = 1;

    /**
     * 被final修饰的static变量，准备阶段会初始化
     */
    private static final int b = 2;

    /**
     * 准备阶段不会为实例变量分配初始化，类变量会分配在方法区中，而实例变量会随着对象一起分配到java堆中
     */
    private Object obj;

    public static void main(String[] args) {
        System.out.println(a);
    }
}
