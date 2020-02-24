package com.wxh.vrp.common;

import com.wxh.vrp.entity.City;
import com.wxh.vrp.entity.Tour;
import com.wxh.vrp.entity.Utility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: 邻域搜索算子
 * @author: wuxinhong
 * @date: 2020/1/17
 * @time: 下午2:53
 */
public class Operators {
    /**
     * 交换两个点
     * @param solution
     * @param index1
     * @param index2
     */
    public static void swap(Tour solution, int index1, int index2){
        City citySwap1 = solution.getCity(index1);
        City citySwap2 = solution.getCity(index2);
        solution.setCity(index1, citySwap2);
        solution.setCity(index2, citySwap1);
    }

    /**
     * 随机交换两个点的位置
     * @param solution
     */
    public static void swapRandom(Tour solution){
        int tourPos1 = Utility.randomInt(0, solution.tourSize());
        int tourPos2 = Utility.randomInt(0, solution.tourSize());
        swap(solution, tourPos1, tourPos2);
    }

    /**
     * 部分翻转
     * @param solution
     * @param begin
     * @param end
     */
    public static void reverseElement(Tour solution, int begin, int end){
        while (begin < end){
            swap(solution, begin, end);
            begin ++;
            end --;
        }
    }

    /**
     * 邻域结构0：使用 reverseElement 算子搜索
     * @param solution
     * @param cityList
     */
    void neighborhoodZero(Tour solution, List<City> cityList){
        Tour currentSolution;
        int count = 0;
        int max_no_improve = 10;
        do{
            count++;
            for(int i=0; i < cityList.size()-1; i++){
                for(int j = i+1; j < cityList.size(); j++){
                    currentSolution = new Tour(solution.getTour());
                    reverseElement(currentSolution, i, j);
                    int currentDistance = currentSolution.getTotalDistance();
                    int distance = solution.getTotalDistance();
                    if(currentDistance < distance){
                        solution = currentSolution;
                        // count 复位
                        count = 0;
                    }
                }
            }
        }while (count <= max_no_improve);
    }

    /**
     * two_opt_swap 算子
     * @param solution
     * @param a
     * @param b
     */
    void twoOptSwap(Tour solution, int a, int b){

    }

    public static void swap(int[] arr, int a, int b){
        while (a<b){
            int temp = arr[a];
            arr[a++] = arr[b];
            arr[b--] = temp;
        }
    }

    public static void reverse(int[] arr, int a, int b){
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<a; i++){
            list.add(arr[i]);
        }
        for(int i=b; i>=a; i--){
            list.add(arr[i]);
        }
        for(int i=b+1; i<arr.length; i++){
            list.add(i);
        }
        for(int i=0; i<arr.length; i++){
            arr[i] = list.get(i);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6,7,8,9};
        Arrays.stream(arr).forEach(System.out::print);
        swap(arr, 3, 8);
        System.out.println();
        Arrays.stream(arr).forEach(System.out::print);
        reverse(arr, 3, 8);
        System.out.println();
        Arrays.stream(arr).forEach(System.out::print);
    }
}
