package com.wxh.leetcode.done;

/**
 * @description:
 * @author: wuxinhong
 * @date: 2020/6/2
 * @time: 下午12:37
 * Copyright (C) 2020 MTDP
 * All rights reserved
 */
public class Leetcode64 {
    public static void main(String[] args) {
        Leetcode64 leetcode64 = new Leetcode64();
        System.out.println(leetcode64.sumNums(8));
    }
    public int sumNums(int n) {
        int res = 1;
        boolean b = n > 1 && ((res = n + sumNums(n - 1)) > 1);
        return res;
    }
}
