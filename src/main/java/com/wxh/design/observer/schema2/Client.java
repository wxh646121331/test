package com.wxh.design.observer.schema2;

/**
 * @description:
 * @author: wuxinhong
 * @date: 2019/11/18
 * @time: 下午10:58
 */
public class Client {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        Observer observer1 = new CurrentConditions();
        weatherData.registerObserver(observer1);
        weatherData.setData(12f, 23f, 49f);
        Observer observer2 = new BaiduSite();
        weatherData.registerObserver(observer2);
        weatherData.setData(13f, 34f, 59f);
        weatherData.removeObserver(observer1);
        weatherData.setData(14f, 37f, 49f);
    }
}
