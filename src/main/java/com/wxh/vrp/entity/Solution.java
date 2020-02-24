package com.wxh.vrp.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @description:
 * @author: wuxinhong
 * @date: 2020/2/3
 * @time: 下午4:43
 * Copyright (C) 2019 MTDP
 * All rights reserved
 */
public class Solution implements Cloneable{
    final City[] cities;
    final double[][] distance;
    /**
     * 城市排列
     */
    Integer[] permutation;

    public Solution(City[] cities){
        this.cities = cities;
        distance = new double[cities.length][cities.length];
        for(int i=0; i<cities.length-1; i++){
            for(int j=i+1; j<cities.length; j++){
                distance[i][j] = Utility.distance(cities[i], cities[j]);
                distance[j][i] = distance[i][j];
            }
        }
        permutation = new Integer[cities.length];
        for(int i=0; i<cities.length; i++){
            permutation[i] = i;
        }
    }

    /**
     * 随机生成城市排列顺序
     */
    public void shuffle(){
        List<Integer> listIndex = Arrays.asList(permutation);
        Collections.shuffle(listIndex);
        listIndex.toArray(permutation);
    }



    /**
     * 计算解的总路径
     * @return
     */
    public double totalCost(){
        double cost = 0;
        for(int i=0; i<permutation.length-1; i++){
            cost = cost + distance[i][i+1];
        }
        cost += distance[permutation.length-1][0];
        return cost;
    }

    /**
     * 将城市序列分成4块，然后按块重新打扰顺序
     * 用于扰动函数
     */
    public void doubleBridgeMove(){
        int pos1 = Utility.randomInt(1, cities.length/4);
        int pos2 = pos1 + Utility.randomInt(1, cities.length/4);
        int pos3 = pos2 + Utility.randomInt(1, cities.length/4);
        List<Integer> indexList = new ArrayList<>(cities.length);
        int i;
        // 第一块
        for(i=0; i<pos1; i++){
            indexList.add(permutation[i]);
        }
        for(i=pos3; i<cities.length; i++){
            indexList.add(permutation[i]);
        }
        for(i=pos2; i<pos3; i++){
            indexList.add(permutation[i]);
        }
        for(i=pos1; i<pos2; i++){
            indexList.add(permutation[i]);
        }
        indexList.toArray(permutation);
    }

    public int citySize(){
        return cities.length;
    }

    @Override
    public Solution clone(){
        Solution solution = new Solution(this.cities);
        Integer[] permutation = new Integer[cities.length];
        for(int i=0; i<cities.length; i++){
            permutation[i] = this.permutation[i];
        }
        solution.permutation = permutation;
        return solution;
    }

    /**
     * 领域结构：使用 two_opt_swap 算子
     */
    public void neighborhoodTwoOptSwap(){
        int count = 0;
//        double[][] delta = new double[citySize()][citySize()];
        int maxNoImprove = 60;
        double initCost = totalCost();
        double currentCost = 0;
        do{
            count++;
            for(int i=0; i<citySize()-1; i++){

                for(int k=i+1; k<citySize(); k++){
                    List<Integer> listIndex = twoHOptSwapPermutation(i, k);
                    double delta = calcDelta(listIndex);
                    if(delta < 0){
                        listIndex.toArray(permutation);
                        count = 0;
                    }
                }
            }
        }while (count < maxNoImprove);
    }

    public void neighborhoodTwoHOptSwap(){
        int count = 0;
        int maxNoImprove = 60;
        do{
            count++;
            for(int i=0; i<citySize()-1; i++){
                for(int k=i+1; k<citySize(); k++){
                    List<Integer> listIndex = twoHOptSwapPermutation(i, k);
                    double delta = calcDelta(listIndex);
                    if(delta < 0){
                        listIndex.toArray(permutation);
                        count = 0;
                    }
                }
            }
        }while (count<=maxNoImprove);
    }

    void twoOptSwap(int b, int c){
        List<Integer> listIndex = twoOptSwapPermutation(b, c);
        listIndex.toArray(permutation);
    }

    List<Integer> twoOptSwapPermutation(int b, int c){
        List<Integer> listIndex = new ArrayList<>(cities.length);
        for(int i=0; i<b; i++){
            listIndex.add(permutation[i]);
        }
        for(int i= c; i>=b; i--){
            listIndex.add(permutation[i]);
        }
        for(int i=c+1; i<citySize(); i++){
            listIndex.add(permutation[i]);
        }
        return listIndex;
    }

    void twoHOptSwap(int a, int d){
        List<Integer> listIndex = twoHOptSwapPermutation(a, d);
        listIndex.toArray(permutation);
    }

    List<Integer> twoHOptSwapPermutation(int a, int d){
        int n = citySize();
        List<Integer> listIndex = new ArrayList<>(citySize());
        listIndex.add(permutation[a]);
        listIndex.add(permutation[d]);
        for(int i=1; i<n; i++){
            int idx = (a+i) % n;
            if(idx != d){
                listIndex.add(permutation[i]);
            }
        }
        return listIndex;
    }

    double calcDelta(List<Integer> listIndex){
        double dis = 0;
        for(int i=0; i<listIndex.size()-1; i++){
            dis += distance[listIndex.get(i)][listIndex.get(i+1)];
        }
        dis += distance[listIndex.get(listIndex.size()-1)][listIndex.get(0)];
        return dis - totalCost();
    }

}
