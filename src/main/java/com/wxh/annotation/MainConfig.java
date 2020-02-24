package com.wxh.annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

/**
 * @description: 配置类
 * @author: wuxinhong
 * @date: 2020/2/16
 * @time: 下午6:26
 * Copyright (C) 2019 MTDP
 * All rights reserved
 */
@Configuration
//@ComponentScan(value = "com.wxh.annotation", excludeFilters = {
//        @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class})
//})
@ComponentScan(value = "com.wxh.annotation", includeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class})}, useDefaultFilters = false)
/**
 * @ComponentScan value: 指定要扫描的包
 * excludeFilters = Filter[] : 排除指定的组件
 * includeFilters = Filter[] : 扫描的时候只包含哪些组件
 */
public class MainConfig {
    /**
     * 给容器注册一个bean
     * @return
     */
    @Bean("person01")
    public Person person(){
        return new Person("lishi", 20);
    }
}
