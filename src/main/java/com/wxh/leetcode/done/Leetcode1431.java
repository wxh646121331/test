package com.wxh.leetcode.done;

import java.util.ArrayList;
import java.util.List;

/**
 * 拥有最多糖果的孩子
 * 给你一个数组 candies 和一个整数 extraCandies ，其中 candies[i] 代表第 i 个孩子拥有的糖果数目。
 * 对每一个孩子，检查是否存在一种方案，将额外的 extraCandies 个糖果分配给孩子们之后，此孩子有最多的糖果。注意，允许有多个孩子同时拥有最多的糖果数目。
 *
 */
public class Leetcode1431 {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0;
        for(int i=0; i<candies.length; i++){
            if(candies[i] > max){
                max = candies[i];
            }
        }
        List<Boolean> list = new ArrayList<>(candies.length);
        for(int i=0; i<candies.length; i++){
            if(candies[i]+extraCandies >= max){
                list.add(Boolean.TRUE);
            }else {
                list.add(Boolean.FALSE);
            }
        }
        return list;
    }
}
