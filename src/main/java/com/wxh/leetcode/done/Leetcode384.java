package com.wxh.leetcode.done;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wuxinhong
 * @date 2021/11/22 10:50 上午
 */
public class Leetcode384 {
    private List<Integer> list;

    public Leetcode384(int[] nums) {
        list = new ArrayList<>(nums.length);
        for(int num : nums){
            list.add(num);
        }
    }

    public int[] reset() {
        int[] nums = new int[list.size()];
        int i=0;
        for(Integer num : list){
            nums[i++] = num;
        }
        return nums;
    }

    public int[] shuffle() {
        int[] nums = reset();
        for(int i=nums.length-1; i>=0; i--){
            // 从0到i中取随机数
            int index = (int) (Math.random() * (i + 1));
            // 将随机取到的索引上的数与第i个数交换
            int temp = nums[index];
            nums[index] = nums[i];
            nums[i] = temp;
        }
        return nums;
    }
}
