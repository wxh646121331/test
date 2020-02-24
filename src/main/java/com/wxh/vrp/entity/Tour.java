package com.wxh.vrp.entity;

import com.wxh.vrp.sa.TourManager;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @description:
 * @author: wuxinhong
 * @date: 2020/1/13
 * @time: 上午10:44
 */
public class Tour {
    private ArrayList<City> tour = new ArrayList<>();

    private int distance = 0;

    private TourManager tourManager;

    public Tour(TourManager tourManager){
        this.tourManager = tourManager;
        for(int i = 0; i < tourManager.numberOfCities(); i++){
            tour.add(null);
        }
        generateIndividual();
    }

    public Tour(ArrayList<City> tour){
        this.tour = (ArrayList<City>) tour.clone();
    }

    public ArrayList<City> getTour(){
        return tour;
    }

    /**
     * 随机生成一条线路
     */
    private void generateIndividual(){
        for(int cityIndex=0; cityIndex < tourManager.numberOfCities(); cityIndex++){
            setCity(cityIndex, tourManager.getCity(cityIndex));
        }
        // Randomly reorder the tour
        Collections.shuffle(tour);
    }

    public City getCity(int index){
        return tour.get(index);
    }

    public void setCity(int index, City city){
        tour.set(index , city);
        // If the tour has been altered, we need to reset the fitness and distance
        distance = 0;
    }

    public int getTotalDistance(){
        if(distance == 0){
            int tourDistance = 0;
            for(int cityIndex = 0; cityIndex < tourSize(); cityIndex++){
                City fromCity = getCity(cityIndex);
                City destinationCity;
                if(cityIndex < tourSize()-1){
                    destinationCity = getCity(cityIndex+1);
                }else {
                    destinationCity = getCity(0);
                }
                tourDistance += Utility.distance(fromCity, destinationCity);
            }
            distance = tourDistance;
        }
        return distance;
    }

    public int tourSize(){
        return tour.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getCity(0).getCityName());
        for(int i=1; i< tourSize(); i++){
            sb.append(" -> ").append(getCity(i).getCityName());
        }
        return sb.toString();
    }
}
