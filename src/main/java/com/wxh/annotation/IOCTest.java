package com.wxh.annotation;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @description:
 * @author: wuxinhong
 * @date: 2020/2/16
 * @time: 下午6:38
 * Copyright (C) 2019 MTDP
 * All rights reserved
 */
public class IOCTest {
    @Test
    public void test1(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        String[] names = applicationContext.getBeanDefinitionNames();
        for(String name : names){
            System.out.println(name);
        }
    }
}
