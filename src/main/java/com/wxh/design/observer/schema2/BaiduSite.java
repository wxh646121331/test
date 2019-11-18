package com.wxh.design.observer.schema2;

/**
 * @description:
 * @author: wuxinhong
 * @date: 2019/11/18
 * @time: 下午11:08
 */
public class BaiduSite implements Observer{
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
        System.out.println("baidu temperature: "+this.temperature);
        System.out.println("baidu pressure: " + this.pressure);
        System.out.println("baidu humidity: " + this.humidity);
    }
}
