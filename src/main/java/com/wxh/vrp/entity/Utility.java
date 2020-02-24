package com.wxh.vrp.entity;

import java.util.Random;

/**
 * @description:
 * @author: wuxinhong
 * @date: 2020/1/14
 * @time: 上午10:06
 */
public class Utility {
    /**
     * 计算两个城市之间的距离
     * @param fromCity
     * @param destinationCity
     * @return
     */
    public static double distance(City fromCity, City destinationCity){
        int xDistance = Math.abs(fromCity.getX() - destinationCity.getX());
        int yDistance = Math.abs(fromCity.getY() - destinationCity.getY());
        double distance = Math.sqrt((xDistance * xDistance) + (yDistance * yDistance));
        return distance;
    }

    /**
     * 接受移动的概率
     * @param currentDistance
     * @param newDistance
     * @param temperature
     * @return
     */
    public static double acceptanceProbability(int currentDistance, int newDistance, double temperature){
        if(newDistance < currentDistance){
            return 1.0;
        }
        return Math.exp((currentDistance - newDistance) / temperature);
    }

    /**
     * 得到一个 0.0 ~ 1.0 之间的一个随机值
     * @return
     */
    public static double randomDouble(){
        Random r = new Random();
        return r.nextInt(1000) / 1000.0;
    }

    /**
     * 得到一个 min ~ max 之间的一个随机整数
     * @param min
     * @param max
     * @return
     */
    public static int randomInt(int min, int max){
        Random r = new Random();
        double d = min + r.nextDouble() * (max - min);
        return (int)d;
    }
}
