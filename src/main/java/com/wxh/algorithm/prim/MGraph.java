package com.wxh.algorithm.prim;

/**
 * @description:
 * @author: wuxinhong
 * @date: 2020/3/26
 * @time: 上午1:04
 * Copyright (C) 2020 MTDP
 * All rights reserved
 */
public class MGraph {
    int verxs;
    char[] data;
    int[][] weight;

    public MGraph(int verxs){
        this.verxs = verxs;
        data = new char[verxs];
        weight = new int[verxs][verxs];
    }
}
