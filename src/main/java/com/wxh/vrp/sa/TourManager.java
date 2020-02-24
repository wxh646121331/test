package com.wxh.vrp.sa;

import com.wxh.vrp.entity.City;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 城市列表管理类
 * @author: wuxinhong
 * @date: 2020/1/14
 * @time: 上午10:06
 */
public class TourManager {
    private List<City> destinationCities = new ArrayList<>();

    public void addCity(City city){
        destinationCities.add(city);
    }

    public City getCity(int index){
        return destinationCities.get(index);
    }

    public int numberOfCities(){
        return destinationCities.size();
    }
}
