package com.wxh.leetcode;

/**
 * 数据旋转
 * @author wuxinhong
 * @date 2021/7/23 5:42 下午
 */
public class Leetcode189 {
    public void rotate(int[] nums, int k) {
        while (k > 0){
            rightRotate(nums);
            k--;
        }
    }

    private void rightRotate(int[] nums){
        int temp = nums[nums.length-1];
        for(int i=nums.length-1; i>0; i--){
            nums[i] = nums[i-1];
        }
        nums[0] = temp;
    }
}
