package com.wxh.vrp.neighborhood.strategy;

import com.wxh.vrp.common.Operators;
import com.wxh.vrp.constant.NeighborhoodStrategyType;
import com.wxh.vrp.entity.Tour;
import org.springframework.stereotype.Service;

/**
 * @description: 基于 swap 算子邻域调整策略
 * @author: wuxinhong
 * @date: 2020/1/17
 * @time: 下午7:18
 */
@Service
public class SwapStrategy extends AbstractStrategy {
    @Override
    public void operator(Tour solution, int i, int j) {
        Operators.swap(solution, i, j);
    }

    @Override
    public NeighborhoodStrategyType neighborhoodStrategy() {
        return NeighborhoodStrategyType.SWAP;
    }
}
