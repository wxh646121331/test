package com.wxh.algorithm.dijkstra;

import java.util.Arrays;

/**
 * @description:
 * @author: wuxinhong
 * @date: 2020/3/27
 * @time: 下午9:44
 * Copyright (C) 2020 MTDP
 * All rights reserved
 */
public class Graph {
    char[] vertex;
    int[][] matrix;
    VisitedVertex vv;

    public Graph(char[] vertex, int[][] matrix){
        this.vertex = vertex;
        this.matrix = matrix;
    }

    public void show(){
        for(int[] link : matrix){
            System.out.println(Arrays.toString(link));
        }
    }

    public void dijkstra(int start){
        vv = new VisitedVertex(vertex.length, start);
        update(start);
        int index;
        for(int j=1; j<vertex.length; j++){
            index = vv.updateArr();
            update(index);
        }
    }

    // 更新 index 顶点到周围顶点的距离和周围顶点的前驱顶点
    public void update(int index){
        int len = 0;
        for(int j=0; j<matrix[index].length; j++){
            if(matrix[index][j] < vv.getDis(j)){
                len = vv.getDis(index) + matrix[index][j];
                if(!vv.isVisited(j) && len < vv.getDis(j)){
                    vv.updateDis(j, len);
                    vv.updatePre(j, index);
                }
            }
        }
    }

    public void showDijkstra(){
        vv.show();
    }
}
