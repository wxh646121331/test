package com.wxh.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.annotation.Resource;

/**
 * @description:
 * @author: wuxinhong
 * @date: 2020/2/16
 * @time: 下午6:27
 * Copyright (C) 2019 MTDP
 * All rights reserved
 */
public class MainTest {
    @Resource
    Person person;
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        Person person = applicationContext.getBean(Person.class);
        System.out.println(person);

        String[] namesForType = applicationContext.getBeanNamesForType(Person.class);
        for(String name : namesForType){
            System.out.println(name);
        }
        MainTest mainTest = new MainTest();
        System.out.println(mainTest);
    }
}
