package com.wxh.algorithm.binarysearch;

/**
 * @description:
 * @author: wuxinhong
 * @date: 2020/3/24
 * @time: 下午3:19
 * Copyright (C) 2020 MTDP
 * All rights reserved
 */
public class BinarySearchNoRecur {
    public static void main(String[] args) {
        int[] arr = {1,3,8,10,11,67,100};
        int index = binarySearch(arr, 1);
        System.out.println("index = " + index);
        index = binarySearch(arr, 100);
        System.out.println("index = " + index);
        index = binarySearch(arr, 10);
        System.out.println("index = " + index);
        index = binarySearch(arr, 18);
        System.out.println("index = " + index);
    }

    public static int binarySearch(int[] arr, int target){
        int left = 0;
        int right = arr.length - 1;
        while (left <= right){
            int mid = (left + right) / 2;
            if(arr[mid] == target){
                return mid;
            }
            if(arr[mid] > target){
                right = mid -1;
            }else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
