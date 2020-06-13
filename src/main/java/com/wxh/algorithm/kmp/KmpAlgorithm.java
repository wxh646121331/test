package com.wxh.algorithm.kmp;

import java.util.Arrays;

/**
 * @description:
 * @author: wuxinhong
 * @date: 2020/3/25
 * @time: 下午10:57
 * Copyright (C) 2020 MTDP
 * All rights reserved
 */
public class KmpAlgorithm {
    public static void main(String[] args) {
        String str1 = "BBC ABCDAB ABCDABCDABDE";
        String str2 = "ABCDABD";
        int[] next = kmpNext(str2);
        System.out.println(Arrays.toString(next));
        int index = kmpSearch(str1, str2);
        System.out.println(index);
    }

    public static int kmpSearch(String str1, String str2){
        int[] next = kmpNext(str2);
        for(int i=0, j=0; i<str1.length(); i++){
            while (j>0 && str1.charAt(i)!=str2.charAt(j)){
                j = next[j-1];
            }
            if(str1.charAt(i) == str2.charAt(j)){
                j++;
            }
            if(j==str2.length()){
                return i-j+1;
            }
        }
        return -1;
    }

    /**
     * 获取到一个字符串（子串）的部分匹配表值
     * @param dest
     * @return
     */
    public static int[] kmpNext(String dest){
        int [] next = new int[dest.length()];
        next[0] = 0;
        for(int i=1,j=0; i<dest.length(); i++){
            // 当dest.charAt(i) != dest.charAt(j) 时，需要从next[j-1]获取新的j
            // 走到发现有dest.charAt[i]==dest.charAt[j]成立才退出
            while(j>0 && dest.charAt(i) != dest.charAt(j)){
                j = next[j-1];
            }
            // 当dest.charAt(i) == dest.charAt(j) 满足时，部分匹配值就是+1
            if(dest.charAt(i) == dest.charAt(j)){
                j++;
            }
            next[i] = j;
        }
        return next;
    }
}
