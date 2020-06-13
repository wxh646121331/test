package com.wxh.leetcode.done;

import java.util.Arrays;

/**
 * @description:
 * @author: wuxinhong
 * @date: 2020/6/5
 * @time: 上午9:06
 * Copyright (C) 2020 MTDP
 * All rights reserved
 */
public class Interview29 {
    public static void main(String[] args) throws InterruptedException {
        int[][] matrix = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        Interview29 interview29 = new Interview29();
        int[] res = interview29.spiralOrder(matrix);
        System.out.println(Arrays.toString(res));
    }

    public int[] spiralOrder(int[][] matrix) {
        if(matrix.length == 0 || matrix[0].length==0){
            return new int[0];
        }
        int len = matrix.length * matrix[0].length;
        int[] res = new int[len];
        int xStart = 0, xEnd = matrix.length-1;
        int yStart = 0, yEnd = matrix[0].length-1;
        int index = 0;
        while (true){
            for(int i=yStart; i<=yEnd; i++){
                res[index++] = matrix[xStart][i];
            }
            if(index == len){
                break;
            }
            xStart ++;
            for(int i=xStart; i<=xEnd; i++){
                res[index++] = matrix[i][yEnd];
            }
            if(index == len){
                break;
            }
            yEnd--;
            for(int i=yEnd; i>=yStart; i--){
                res[index++] = matrix[xEnd][i];
            }
            if(index == len){
                break;
            }
            xEnd--;
            for(int i=xEnd; i>=xStart; i--){
                res[index++] = matrix[i][yStart];
            }
            if(index == len){
                break;
            }
            yStart ++;
        }
        return res;
    }
}
