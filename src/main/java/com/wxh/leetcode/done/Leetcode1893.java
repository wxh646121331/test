package com.wxh.leetcode.done;

/**
 * 区间是否补覆盖
 * @author wuxinhong
 * @date 2021/7/23 8:49 上午
 */
public class Leetcode1893 {
    public static boolean isCovered(int[][] ranges, int left, int right) {
        return isCovered(ranges, 0, left, right);
    }

    public static boolean isCovered(int[][] ranges, int startIndex, int left, int right) {
        if(left > right){
            return true;
        }
        for(int i=startIndex; i<ranges.length; i++){
            int min = ranges[i][0];
            int max = ranges[i][1];
            if(min<=left && max>=right){
                return true;
            }
            if(min>right | max<left){
                continue;
            }
            if(isCovered(ranges, i+1, left, min-1) && isCovered(ranges, i+1, max+1, right)){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] ranges = new int[][]{{37,49},{5,17},{8,32}};
        boolean res = isCovered(ranges, 29, 49);
        System.out.println(res);
    }

    /**
     * 有序数据的平方
     * @author wuxinhong
     * @date 2021/7/23 4:45 下午
     */
    public static class Leetcode977 {
        public int[] sortedSquares(int[] nums) {
            int minIndex = 0;
            for(int i=1; i<nums.length; i++){
                if(nums[i]*nums[i] <= nums[minIndex]*nums[minIndex]){
                    minIndex = i;
                }else {
                    break;
                }
            }
            int [] result = new int[nums.length];
            int i=0;
            result[i++] = nums[minIndex] * nums[minIndex];
            int left = minIndex-1;
            int right = minIndex+1;
            while (left>=0 && right<nums.length){
                int squareL = nums[left] * nums[left];
                int squareR = nums[right] * nums[right];
                if(squareL < squareR){
                    result[i] = squareL;
                    left--;
                }else {
                    result[i] = squareR;
                    right++;
                }
                i++;
            }
            for(; left>=0; left--){
                result[i++] = nums[left] * nums[left];
            }
            for(; right < nums.length; right++){
                result[i++] = nums[right] * nums[right];
            }
            return result;
        }
    }
}
