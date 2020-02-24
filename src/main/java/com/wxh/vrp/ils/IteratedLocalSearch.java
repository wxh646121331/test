package com.wxh.vrp.ils;

import com.wxh.vrp.entity.City;
import com.wxh.vrp.entity.Tour;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 迭代局部搜索
 * @author: wuxinhong
 * @date: 2020/1/15
 * @time: 上午12:02
 */
public class IteratedLocalSearch {
    static List<City> cities;
    private static int citySize;

    static {
        // 城市坐标，最优解：7542
        int[][] coors = new int[][]{ { 565,575 },{ 25,185 },{ 345,750 },{ 945,685 },{ 845,655 },
                { 880,660 },{ 25,230 },{ 525,1000 },{ 580,1175 },{ 650,1130 },{ 1605,620 },
                { 1220,580 },{ 1465,200 },{ 1530,5 },{ 845,680 },{ 725,370 },{ 145,665 },
                { 415,635 },{ 510,875 },{ 560,365 },{ 300,465 },{ 520,585 },{ 480,415 },
                { 835,625 },{ 975,580 },{ 1215,245 },{ 1320,315 },{ 1250,400 },{ 660,180 },
                { 410,250 },{ 420,555 },{ 575,665 },{ 1150,1160 },{ 700,580 },{ 685,595 },
                { 685,610 },{ 770,610 },{ 795,645 },{ 720,635 },{ 760,650 },{ 475,960 },
                { 95,260 },{ 875,920 },{ 700,500 },{ 555,815 },{ 830,485 },{ 1170,65 },
                { 830,610 },{ 605,625 },{ 595,360 },{ 1340,725 },{ 1740,245 } };
        cities = new ArrayList<>(coors.length);
        for(int i=0; i<coors.length; i++){
            int[] coor = coors[i];
            City city = new City("city"+(i+1), coor[0], coor[1]);
            cities.add(city);
        }
        citySize = cities.size();
    }

    public static void main(String[] args) {
        // 最大迭代次数
        int maxIterations = 600;
        int maxNoImprove = 50;
        double[][] delta = new double[citySize][citySize];
    }

    private static void iteratedLocalSearch(Tour bestSolution){

    }
}
