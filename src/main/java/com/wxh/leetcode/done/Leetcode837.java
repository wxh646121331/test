package com.wxh.leetcode.done;

/**
 * @description:
 * @author: wuxinhong
 * @date: 2020/6/3
 * @time: 下午8:09
 * Copyright (C) 2020 MTDP
 * All rights reserved
 */
public class Leetcode837 {
    public static void main(String[] args) {
        Leetcode837 leetcode837 = new Leetcode837();
        System.out.println(leetcode837.new21Game(10, 1, 10));
        System.out.println(leetcode837.new21Game(6, 1, 10));
        System.out.println(leetcode837.new21Game(21, 17, 10));
    }

    public double new21Game(int N, int K, int W) {
        double[] arr = new double[K + W];
        int min = Math.min(N, K+W-1);
        for(int i=K+W-1; i>=0; i--){
            if(i > min){
                arr[i] = 0;
            }else if(i >= K && i <= min){
                arr[i] = 1;
            }else if(i==K-1){
                double val = 0.0;
                for(int j=1; j<=W; j++){
                    val += 1.0/W*arr[i+j];
                }
                arr[i] = val;
            }else {
                arr[i] = arr[i+1] + 1.0/W * (arr[i+1] - arr[i+W+1]);
            }
        }
        return arr[0];
    }
}
