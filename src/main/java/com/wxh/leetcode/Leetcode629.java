package com.wxh.leetcode;

/**
 * @author wuxinhong
 * @date 2021/11/11 3:36 下午
 */
public class Leetcode629 {
    public int kInversePairs(int n, int k) {
        int max = n * (n -1) /2;
        if(k > max || n <= 0){
            return 0;
        }
        if(k == 0 || k == max){
            return 1;
        }
        int j = Math.min(k, n-1);
        int sum = kInversePairs(n-1, k) + kInversePairs(n, k-1) - kInversePairs(n-1, j);
        return sum;
    }
}
