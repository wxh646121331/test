package com.wxh.leetcode.done;

/**
 * @author wuxinhong
 * @date 2021/11/10 10:55 上午
 */
public class Leetcode495 {
    public static int findPoisonedDuration(int[] timeSeries, int duration) {
        int sum = 0;
        int nextStart = Integer.MAX_VALUE;
        for(int i=timeSeries.length-1; i>=0; i--){
            int curStart = timeSeries[i];
            int curEnd = Math.min(curStart + duration, nextStart);
            sum += curEnd - curStart;
            nextStart = curStart;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] timeSeries = new int[]{1, 4};
        System.out.println(findPoisonedDuration(timeSeries, 5));
    }
}
