package com.wxh.design.observer.schema1;

/**
 * @description:
 * @author: wuxinhong
 * @date: 2019/11/17
 * @time: 下午6:49
 * 问题分析：
 * 1）其它第三方接入气象丫获取数据的问题
 * 2）无法在运行时动态的添加第三方
 */
public class Client {
    public static void main(String[] args) {
        CurrentConditions currentConditions = new CurrentConditions();
        WeatherData weatherData = new WeatherData(currentConditions);
        weatherData.setData(30, 150, 40);
    }
}
