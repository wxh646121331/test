package com.wxh.vrp.sa;

import com.wxh.vrp.common.Operators;
import com.wxh.vrp.entity.City;
import com.wxh.vrp.entity.Tour;
import com.wxh.vrp.entity.Utility;

/**
 * @description:
 * @author: wuxinhong
 * @date: 2020/1/14
 * @time: 上午10:06
 */
public class SimulatedAnnealing {
    public static void main(String[] args) {
        // 城市定义
        TourManager tourManager = initCities2();
        // 定义初始温度
        double temp = 100000;
        // 降温速度
        double coolingRate = 0.002;

        // 随机生成初始解
        Tour currentSolution = new Tour(tourManager);

        System.out.println("Total distance of initial solution: " + currentSolution.getTotalDistance());

        Tour best = new Tour(currentSolution.getTour());
        int count = 0;
        long start = System.currentTimeMillis();
        while (temp > 1){
            Tour newSolution = new Tour(currentSolution.getTour());
            // 随机交换两个城市
            Operators.swapRandom(newSolution);
            int currentDistance = currentSolution.getTotalDistance();
            int neighbourDistance = newSolution.getTotalDistance();
            // 接受邻域的概率
            double rand = Utility.randomDouble();
            if(Utility.acceptanceProbability(currentDistance, neighbourDistance, temp) > rand){
                currentSolution = new Tour(newSolution.getTour());
            }
            // 保存搜索过的最好解
            if(currentSolution.getTotalDistance() < best.getTotalDistance()){
                best = new Tour(currentSolution.getTour());
            }
            // 降温
            temp *= 1 - coolingRate;
            count ++;
        }
        int finalDistance = best.getTotalDistance();
        System.out.println("Total distance of best solution: " + finalDistance);
        System.out.println("The route of best solution: " + best.toString());
        System.out.println("迭代次数：" + count);
        long end = System.currentTimeMillis();
        long time = end - start;
        System.out.println("迭代耗时：" + time);
    }

    private static TourManager initCities1(){
        TourManager tourManager = new TourManager();
        City city1 = new City("Paris", 60, 200);
        tourManager.addCity(city1);
        City city2 = new City("Lyon", 180, 200);
        tourManager.addCity(city2);
        City city3 = new City("La Rochelle", 80, 100);
        tourManager.addCity(city3);
        City city4 = new City("Bordeaus", 140, 180);
        tourManager.addCity(city4);
        City city5 = new City("Lenz", 20, 160);
        tourManager.addCity(city5);
        City city6 = new City("Nice", 100, 160);
        tourManager.addCity(city6);
        City city7 = new City("Lille", 200, 160);
        tourManager.addCity(city7);
        City city8 = new City("Rennes", 140, 140);
        tourManager.addCity(city8);
        City city9 = new City("Brest", 40, 120);
        tourManager.addCity(city9);
        City city10 = new City("Toulon", 100, 120);
        tourManager.addCity(city10);
        City city11 = new City("Nancy", 180, 100);
        tourManager.addCity(city11);
        City city12 = new City("Calais", 60, 80);
        tourManager.addCity(city12);
        return tourManager;
    }

    private static TourManager initCities2(){
        TourManager tourManager = new TourManager();
        int[][] coors = new int[][]{ { 565,575 },{ 25,185 },{ 345,750 },{ 945,685 },{ 845,655 },
                { 880,660 },{ 25,230 },{ 525,1000 },{ 580,1175 },{ 650,1130 },{ 1605,620 },
                { 1220,580 },{ 1465,200 },{ 1530,5 },{ 845,680 },{ 725,370 },{ 145,665 },
                { 415,635 },{ 510,875 },{ 560,365 },{ 300,465 },{ 520,585 },{ 480,415 },
                { 835,625 },{ 975,580 },{ 1215,245 },{ 1320,315 },{ 1250,400 },{ 660,180 },
                { 410,250 },{ 420,555 },{ 575,665 },{ 1150,1160 },{ 700,580 },{ 685,595 },
                { 685,610 },{ 770,610 },{ 795,645 },{ 720,635 },{ 760,650 },{ 475,960 },
                { 95,260 },{ 875,920 },{ 700,500 },{ 555,815 },{ 830,485 },{ 1170,65 },
                { 830,610 },{ 605,625 },{ 595,360 },{ 1340,725 },{ 1740,245 } };
        for(int i=0; i<coors.length; i++){
            int[] coor = coors[i];
            City city = new City("city"+(i+1), coor[0], coor[1]);
            tourManager.addCity(city);
        }
        return tourManager;
    }
}
