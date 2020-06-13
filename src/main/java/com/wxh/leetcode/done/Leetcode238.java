package com.wxh.leetcode.done;

import java.util.Arrays;

/**
 *
 */
public class Leetcode238 {
    public static void main(String[] args) {
        Leetcode238 leetcode238 = new Leetcode238();
        int[] nums = {1,2,3,4};
        int[] res = leetcode238.productExceptSelf(nums);
        System.out.println(Arrays.toString(res));
    }
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int temp = 1;
        res[0] = temp;
        for(int i=1; i<nums.length; i++){
            temp *= nums[i-1];
            res[i] = temp;
        }
        temp = 1;
        for(int i=nums.length-2; i>=0; i--){
            temp *= nums[i+1];
            res[i] = res[i] * temp;
        }
        return res;
    }
}
