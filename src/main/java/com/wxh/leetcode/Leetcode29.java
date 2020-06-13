package com.wxh.leetcode;

/**
 * @description:
 * @author: wuxinhong
 * @date: 2020/6/2
 * @time: 下午11:48
 * Copyright (C) 2020 MTDP
 * All rights reserved
 */
public class Leetcode29 {
    public int divide(int dividend, int divisor) {
        /* 将除数转成正数*/
        if(divisor<0){
            dividend = -dividend;
            divisor = -divisor;
        }
        if(divisor == 1){
            return dividend;
        }
        return 0;
    }
}
