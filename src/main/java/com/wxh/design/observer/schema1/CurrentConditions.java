package com.wxh.design.observer.schema1;

/**
 * @description:
 * @author: wuxinhong
 * @date: 2019/11/17
 * @time: 下午6:08
 * Copyright (C) 2019 MTDP
 * All rights reserved
 */
public class CurrentConditions {
    private float temperature;
    private float pressure;
    private float humidity;

    public void update(float temperature, float pressure, float humidity){
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        display();
    }
    public void display(){
        System.out.println("temperature: "+this.temperature);
        System.out.println("pressure: " + this.pressure);
        System.out.println("humidity: " + this.humidity);
    }
}
