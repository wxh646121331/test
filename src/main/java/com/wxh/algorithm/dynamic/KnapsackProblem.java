package com.wxh.algorithm.dynamic;

/**
 * @description:
 * @author: wuxinhong
 * @date: 2020/3/25
 * @time: 上午9:54
 * Copyright (C) 2020 MTDP
 * All rights reserved
 */
public class KnapsackProblem {
    public static void main(String[] args) {
        // 物品的重量
        int[] w = {1, 3, 4};
        // 物品的价值
        int[] val = {1500, 3000, 4000};
        // 背包的容量
        int m = 4;
        // 物品的个数
        int n = val.length;
        // 创建二维数据，v[i][j] 表示在前i个物品中，容量j的容量能装入的最大价值
        int[][] v = new int[n+1][m+1];
        // 存放商品路径
        boolean[][] path = new boolean[n+1][m+1];
        // 初始化第一行和第一列
        for(int i=0; i<v.length; i++){
            v[i][0] = 0;
        }
        for(int i=0; i<v[0].length; i++){
            v[0][i] = 0;
        }
        // 根据公式进行动态规划处理，不处理第一行和第一列
        for(int i=1; i<v.length; i++){
            for(int j=1; j<v[0].length; j++){
                if(w[i-1] > j){
                    v[i][j] = v[i-1][j];
                }else {
//                    v[i][j] = Math.max(v[i-1][j], v[i-1][j-w[i-1]]+val[i-1]);
                    if(v[i-1][j] > v[i-1][j-w[i-1]]+val[i-1]){
                        v[i][j] = v[i-1][j];
                    }else {
                        v[i][j] = v[i-1][j-w[i-1]]+val[i-1];
                        path[i][j] = true;
                    }
                }
            }
        }
        // 打印二维数组
        for(int i=0; i<v.length; i++){
            for(int j=0; j<v[0].length; j++){
                System.out.print(v[i][j]+" ");
            }
            System.out.println();
        }

        int i = path.length - 1;
        int j = path[0].length -1;
        while (i>0 && j>0){
            if(path[i][j]){
                System.out.println(String.format("第%d个商品放入背包", i));
                j = j-w[i-1];
            }
            i--;
        }
    }
}
