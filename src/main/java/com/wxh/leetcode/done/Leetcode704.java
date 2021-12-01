package com.wxh.leetcode.done;

/**
 * @author wuxinhong
 * @date 2021/7/22 3:29 下午
 */
public class Leetcode704 {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        int mid = 0;
        while (start <= end){
            mid = start + (end - start) / 2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] < target){
                start = mid + 1;
            }else {
                end = mid - 1;
            }
        }
        if(nums[mid] > target){
            return mid;
        }else {
            return mid+1;
        }
    }
}
