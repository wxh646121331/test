package com.wxh.algorithm.prim;

import java.util.Arrays;

/**
 * @description:
 * @author: wuxinhong
 * @date: 2020/3/26
 * @time: 上午1:06
 * Copyright (C) 2020 MTDP
 * All rights reserved
 */
public class MinTree {
    /**
     * 创建图的邻接矩阵
     * @param graph 图对象
     * @param verxs 顶点个数
     * @param data 顶点的值
     * @param weight 图的邻接矩阵
     */
    public void createGraph(MGraph graph, int verxs, char[] data, int[][] weight){
        for(int i=0; i<verxs; i++){
            graph.data[i] = data[i];
            for(int j = 0; j<verxs; j++){
                graph.weight[i][j] = weight[i][j];
            }
        }
    }

    public void showGraph(MGraph graph){
        for(int[] link : graph.weight){
            System.out.println(Arrays.toString(link));
        }
    }

    /**
     * prim 算法，得到最小生成树
     * @param graph
     * @param v 表示从图的第几个顶点开始生成
     */
    public void prim(MGraph graph, int v){
        // 标记顶点是否被访问过
        boolean[] visited = new boolean[graph.verxs];
        // 把当前这个顶点标记得已访问
        visited[v] = true;
        // h1 和 h2 记录两个顶点的下标
        int h1 = -1;
        int h2 = -1;
        int minWeight = 10000;
        for(int k=1; k<graph.verxs; k++){
            for(int i=0; i<graph.verxs; i++){
                if(!visited[i]){
                    continue;
                }
                for(int j=0; j<graph.verxs; j++){
                    if(!visited[j] && graph.weight[i][j]<minWeight){
                        minWeight = graph.weight[i][j];
                        h1 = i;
                        h2 = j;
                    }
                }
            }
            if(h2>=0){
                System.out.println("边<"+graph.data[h1] + ","+graph.data[h2]+">权值："+minWeight);
                visited[h2] = true;
            }
            minWeight = 10000;
            h1 = -1;
            h2 = -1;
        }
    }

}
