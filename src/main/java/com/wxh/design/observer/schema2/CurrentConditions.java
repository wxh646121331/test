package com.wxh.design.observer.schema2;

/**
 * @description:
 * @author: wuxinhong
 * @date: 2019/11/18
 * @time: 下午10:59
 */
public class CurrentConditions implements Observer{
    private float temperature;
    private float pressure;
    private float humidity;

    @Override
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
