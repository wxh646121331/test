package com.wxh.algorithm.dac;

/**
 * @description: 汉诺塔问题
 * @author: wuxinhong
 * @date: 2020/3/24
 * @time: 下午10:59
 * Copyright (C) 2020 MTDP
 * All rights reserved
 */
public class HanoiTower {
    public static void main(String[] args) {
        hanoiTower(5, 'A', 'B', 'C');
    }

    public static void hanoiTower(int num, char a, char b, char c){
        if(num == 1){
            // 只有一个盘，A->C
            System.out.println("第1个盘从" + a + "->" + c);
        }else {
            // 有2个或2个以上的盘
            //1. 把除最下面的盘以外的所有盘 A->B
            hanoiTower(num-1, a, c, b);
            // 2. 把最下面的盘 A->C
            System.out.println("第" + num +"个盘从" + a + "->" +c);
            // 3. 把B塔所有的盘 B->C
            hanoiTower(num-1, b, a, c);
        }
    }
}
