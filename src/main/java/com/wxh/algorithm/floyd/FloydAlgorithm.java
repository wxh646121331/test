package com.wxh.algorithm.floyd;

/**
 * @description:
 * @author: wuxinhong
 * @date: 2020/4/5
 * @time: 上午12:18
 * Copyright (C) 2020 MTDP
 * All rights reserved
 */
public class FloydAlgorithm {
    static final int N = 65535;
    public static void main(String[] args) {
        char[] vertex = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int[][] matrix = {
                {0, 5, 7, N, N, N, 2},
                {5, 0, N, 9, N, N, 3},
                {7, N, 0, N, 8, N, N},
                {N, 9, N, 0, N, 4, N},
                {N, N, 8, N, 0, 5, 4},
                {N, N, N, 4, 5, 0, 6},
                {2, 3, N, N, 4, 6, 0}
        };
        Graph graph = new Graph(vertex.length, matrix, vertex);
        graph.show();
        graph.floyd();
        graph.show();
    }
}
