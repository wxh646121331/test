package com.wxh.leetcode.done;

import java.util.Arrays;

/**
 * 给定一个已按照 升序排列  的整数数组 numbers ，请你从数组中找出两个数满足相加之和等于目标数 target 。
 *
 * 函数应该以长度为 2 的整数数组的形式返回这两个数的下标值。numbers 的下标 从 1 开始计数 ，所以答案数组应当满足 1 <= answer[0] < answer[1] <= numbers.length 。
 *
 * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 *
 */
public class Leetcode167 {
    public static int[] twoSum2(int[] numbers, int target) {
        int[] res = new int[2];
        int i=0;
        int j=numbers.length-1;
        while (i<j){
            if(numbers[i] + numbers[j] == target){
                res[0] = i + 1;
                res[1] = j+1;
                break;
            }
            if(numbers[i] + numbers[j] > target){
                j--;
            }else {
                i++;
            }
        }
        return res;
    }

    public static int[] twoSum(int[] numbers, int target) {
        for(int i=0; i<numbers.length; i++){
            int j = findTarget(numbers, i + 1, target - numbers[i]);
            if(j > 0){
                int[] result = new int[2];
                result[0] = i+1;
                result[1] = j+1;
                return result;
            }
        }
        return null;
    }

    private static int findTarget(int[] numbers,int start, int target){
        int end = numbers.length - 1;
        int mid;
        while (start <= end){
            mid = start + (end - start) / 2;
            if(numbers[mid] == target){
                return mid;
            }else if(numbers[mid] > target){
                end = mid -1;
            }else {
                start = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] numbers = new int[]{2,7,11,15};
        int[] ints = twoSum2(numbers, 9);
        System.out.println(Arrays.toString(ints));
    }
}
