package com.wxh.vrp.neighborhood.strategy;

import com.wxh.vrp.constant.NeighborhoodStrategyType;
import com.wxh.vrp.entity.Tour;

/**
 * @description: 邻域调整策略抽象类
 * @author: wuxinhong
 * @date: 2020/1/17
 * @time: 下午5:45
 */
public abstract class AbstractStrategy {
    public void adjust(Tour solution){
        Tour currentSolution;
        int cityCount = solution.getTour().size();
        int count = 0;
        int max_no_improve = 10;
        do{
            count++;
            for(int i=0; i < solution.getTour().size()-1; i++){
                for(int j = i+1; j < cityCount; j++){
                    currentSolution = new Tour(solution.getTour());
                    operator(solution, i, j);
                    int currentDistance = currentSolution.getTotalDistance();
                    int distance = solution.getTotalDistance();
                    if(currentDistance < distance){
                        solution = currentSolution;
                        // count 复位
                        count = 0;
                    }
                }
            }
        }while (count <= max_no_improve);
    }

    /**
     * 策略调整算子
     * @param solution
     * @param i
     * @param j
     */
    protected abstract void operator(Tour solution, int i, int j);

    /**
     * 策略类型
     * @return
     */
    public abstract NeighborhoodStrategyType neighborhoodStrategy();
}
