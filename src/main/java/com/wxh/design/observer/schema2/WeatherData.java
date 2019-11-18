package com.wxh.design.observer.schema2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @description:
 * @author: wuxinhong
 * @date: 2019/11/17
 * @time: 下午8:17
 */
public class WeatherData implements Subject{
    private float temperature;
    private float pressure;
    private float humidity;
    private List<Observer> observers;

    public WeatherData(){
        observers = new ArrayList<>();
    }
    public void setData(float temperature, float pressure, float humidity){
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        notifyObservers();
    }
    @Override
    public void registerObserver(Observer observer) {
        if(!observers.contains(observer)){
            observers.add(observer);
        }
    }

    @Override
    public void removeObserver(Observer observer) {
        if(observers.contains(observer)){
            observers.remove(observer);
        }
    }

    @Override
    public void notifyObservers() {
        observers.forEach(observer -> observer.update(temperature, pressure, humidity));
    }
}
