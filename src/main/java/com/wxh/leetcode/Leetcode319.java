package com.wxh.leetcode;

/**
 * @author wuxinhong
 * @date 2021/11/15 2:58 下午
 */
public class Leetcode319 {
    public static int bulbSwitch(int n) {
        int[][] arr = new int[n][n];
        for(int i=0; i<n; i++){
            arr[0][i] = 1;
        }
        for(int i=1; i<n; i++){
            for(int j=0; j<n; j++){
                if((j+1) % (i+1) == 0){
                    arr[i][j] = -arr[i-1][j];
                }else {
                    arr[i][j] = arr[i-1][j];
                }
            }
        }
        int res = 0;
        for(int i=0; i<n; i++){
            if(arr[n-1][i] > 0){
                res++;
            }
        }
        return res;
    }

    public static int bulbSwitch2(int n) {
        return (int) Math.sqrt(n + 0.5);
    }


    /**
     * 第j个灯泡的转换次数
     * @param j
     * @param n
     * @return
     */
    public static int switchTimes(int j, int n){
        int times = 0;
        // 第j个灯泡在第i次是否需要转换
        for(int i=0; i<=j; i++){
            if((j+1) % (i+1) == 0){
                times++;
            }
        }
        return times;
    }

    public static void main(String[] args) {
        System.out.println(bulbSwitch2(99999));
    }
}
