package com.wxh.leetcode.done;

/**
 * @author wuxinhong
 * @date 2021/7/27 3:11 下午
 */
public class Leetcode283 {
    public void moveZeroes(int[] nums) {
        int firstZero = nums.length;
        for(int i=0; i<nums.length; i++){
            if(nums[i] == 0){
                firstZero = i;
                break;
            }
        }
        for(int i=firstZero+1; i<nums.length; i++){
            if(nums[i] != 0){
                nums[firstZero++] = nums[i];
                nums[i] = 0;
            }
        }
    }
}
