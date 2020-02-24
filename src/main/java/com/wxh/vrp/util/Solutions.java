package com.wxh.vrp.util;

import com.wxh.vrp.entity.City;
import com.wxh.vrp.entity.Solution;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: wuxinhong
 * @date: 2020/2/4
 * @time: 下午6:09
 * Copyright (C) 2019 MTDP
 * All rights reserved
 */
public class Solutions {
    public static Solution generationRandomSolution(City[] cities){
        Solution solution = new Solution(cities);
        solution.shuffle();
        return solution;
    }
}
