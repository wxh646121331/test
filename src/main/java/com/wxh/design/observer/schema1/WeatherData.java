package com.wxh.design.observer.schema1;

/**
 * @description:
 * @author: wuxinhong
 * @date: 2019/11/17
 * @time: 下午6:03
 */
public class WeatherData {
    private float temperature;
    private float pressure;
    private float humidity;
    private CurrentConditions currentConditions;

    public WeatherData(CurrentConditions currentConditions){
        this.currentConditions = currentConditions;
    }

    public float getTemperature(){
        return temperature;
    }
    public float getHumidity(){
        return humidity;
    }
    public float getProssure(){
        return pressure;
    }
    public void dataChange(){
        //调用接入方的update方法，推送
        currentConditions.update(getTemperature(), getProssure(), getHumidity());
    }

    public void setData(float temperature, float pressure, float humidity){
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        dataChange();
    }
}
