package com.wxh.algorithm.kmp;

/**
 * @description:
 * @author: wuxinhong
 * @date: 2020/3/25
 * @time: 下午9:11
 * Copyright (C) 2020 MTDP
 * All rights reserved
 */
public class violenceMatch {
    public static void main(String[] args) {
        String str1 = "abc abcdcb acbgeta";
        String str2 = "acbg";
        System.out.println(violenceMath(str1, str2));
    }
    public static int violenceMath(String str1, String str2){
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();

        int s1len = s1.length;
        int s2len = s2.length;

        int i=0;
        int j=0;
        while (i < s1len && j<s2len){
            if(s1[i] == s2[j]){
                i++;
                j++;
            }else {
                i = i - (j-1);
                j=0;
            }
        }
        if(j == s2len){
            return i-j;
        }
        return -1;
    }
}
