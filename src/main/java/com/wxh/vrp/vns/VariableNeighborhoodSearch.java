package com.wxh.vrp.vns;

import com.wxh.vrp.common.DataInit;
import com.wxh.vrp.entity.City;
import com.wxh.vrp.entity.Solution;
import com.wxh.vrp.util.Solutions;

/**
 * @description: 变邻域搜索算法
 * @author: wuxinhong
 * @date: 2020/1/17
 * @time: 下午8:25
 */
public class VariableNeighborhoodSearch {
    public static void main(String[] args) {
        City[] cities = DataInit.initCity52();
        Solution bestSolution = Solutions.generationRandomSolution(cities);
        System.out.println("初始解路径长度：" + bestSolution.totalCost());
        VariableNeighborhoodSearch vns = new VariableNeighborhoodSearch();
        vns.variableNeighborhoodSearch(bestSolution);
        System.out.println("vns 执行结果路径长度：" + bestSolution.totalCost());
    }

    void variableNeighborhoodSearch(Solution bestSolution){
        // 最大迭代次数
        int maxIterations = 5;
        int count=0;
        int iter=0;
        Solution currentSolution = bestSolution.clone();
        do{
            System.out.println("VNS iterated"+(iter+1)+"times");
            count++;
            iter++;
            shaking(currentSolution);
            variableNeighborhoodDescent(currentSolution);
            if(currentSolution.totalCost() < bestSolution.totalCost()){
                bestSolution = currentSolution;
                count = 0;
            }
            System.out.println("bestSolution:"+bestSolution.totalCost());
        }while (count <= maxIterations);
    }

    void shaking(Solution bestSolution){
        bestSolution.doubleBridgeMove();
    }

    void variableNeighborhoodDescent(Solution bestSolution){
        Solution currentSolution = bestSolution.clone();
        int l = 1;
        System.out.println("===============VND================");
        while (true){
            switch (l){
                case 1:
                    neighborhoodOne(currentSolution);
                    if(currentSolution.totalCost() < bestSolution.totalCost()){
                        bestSolution = currentSolution;
                        l = 0;
                    }
                    break;
                case 2:
                    neighborhoodTwo(currentSolution);
                    if(currentSolution.totalCost() < bestSolution.totalCost()){
                        bestSolution = currentSolution;
                        l = 0;
                    }
                    break;
                default:
                    return;
            }
            l++;
        }
    }

    void neighborhoodOne(Solution bestSolution){
        bestSolution.neighborhoodTwoOptSwap();
    }

    void neighborhoodTwo(Solution bestSolution){
        bestSolution.neighborhoodTwoHOptSwap();
    }
}
