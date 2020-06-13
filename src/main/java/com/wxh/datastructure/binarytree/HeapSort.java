package com.wxh.datastructure.binarytree;

import java.util.Arrays;

/**
 * @description:
 * @author: wuxinhong
 * @date: 2020/3/18
 * @time: 上午8:51
 * Copyright (C) 2020 MTDP
 * All rights reserved
 */
public class HeapSort {
    public static void main(String[] args) {
        int arr[] ={4,6,8,5,9};
        heapSort(arr);
        Arrays.stream(arr).forEach(System.out::println);
    }

    public static void heapSort(int arr[]){
        System.out.println("堆排序");
        int length = arr.length;
        for(int i=length/2-1; i>=0; i--){
            adjustHeap(arr, i, length);
        }
        for(int j= length-1; j>0; j--){
            int temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            adjustHeap(arr, 0, j);
        }
    }

    /**
     * 数据堆化，递归实现
     * @param arr 待调整的数组
     * @param i 表示非叶子节点的索引
     * @param length 表示对多少个元素进行调整
     */
    public static void adjustHeap(int arr[], int i, int length){
       if(i > length/2-1){
           return;
       }
       int leftIndex = 2 * i +1;
       if(arr[i]>arr[leftIndex]){
           swap(arr, i, leftIndex);
           adjustHeap(arr, leftIndex, length);
       }
       int rightIndex = 2 * i +2;
       if(rightIndex < length && arr[i]>arr[rightIndex]){
           swap(arr, i, 2*i+2);
           adjustHeap(arr, rightIndex, length);
       }
    }

    public static void adjustHeap1(int arr[], int i, int length){
        int temp = arr[i];
        for(int k=2*i+1; k<length; k=k*2+1){
            if(k+1<length && arr[k]<arr[k+1]){
                k++;
            }
            if(arr[k] > temp){
                arr[i] = arr[k];
                i = k;
            }else {
                break;
            }
        }
        arr[i] = temp;
    }

    static void swap(int arr[], int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
