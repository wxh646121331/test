package com.wxh.algorithm.kruskal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @description:
 * @author: wuxinhong
 * @date: 2020/3/27
 * @time: 上午1:27
 * Copyright (C) 2020 MTDP
 * All rights reserved
 */
public class KruskalAlgorithm {
    private int edgeNum;
    private char[] vertexes;
    private int[][] matrix;
    private static final int INF = Integer.MAX_VALUE;
    /**
     * 顶点对应的终点
     */
    private int[] ends;

    public static void main(String[] args) {
        char[] vertexes = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int[][] matrix = {
                {0, 12, INF, INF, INF, 16, 14},
                {12, 0, 10, INF, INF, 7, INF},
                {INF, 10, 0, 3, 5, 6, INF},
                {INF, INF, 3, 0, 4, INF, INF},
                {INF, INF, 5, 4, 0, 2, 8},
                {16, 7, 6, INF, 2, 0, 9},
                {14, INF, INF, INF, 8, 9, 0}
        };
        KruskalAlgorithm kruskalAlgorithm = new KruskalAlgorithm(vertexes, matrix);
        kruskalAlgorithm.print();
        List<Edge> edgeList = kruskalAlgorithm.getEdges();
        System.out.println(Arrays.toString(edgeList.toArray()));
        kruskalAlgorithm.kruskal();
    }

    public KruskalAlgorithm(char[] vertexes, int[][] matrix){
        int vlen = vertexes.length;
        this.vertexes = new char[vlen];
        this.ends = new int[vlen];
        for(int i=0; i<vertexes.length; i++){
            this.vertexes[i] = vertexes[i];
        }
        this.matrix = new int[vlen][vlen];
        for(int i=0; i<vlen; i++){
            for(int j=0; j<vlen; j++){
                this.matrix[i][j] = matrix[i][j];
                if(matrix[i][j] != INF){
                    edgeNum++;
                }
            }
        }
    }

    public void print(){
        System.out.println("邻接矩阵为：");
        for(int[] link : matrix){
            for(int value : link){
                System.out.printf("%11d", value);
            }
            System.out.println();
        }
    }

    private int getPosition(char ch){
        for(int i=0; i<vertexes.length; i++){
            if(vertexes[i]==ch){
                return i;
            }
        }
        return -1;
    }

    private List<Edge> getEdges(){
        List<Edge> edgeList = new ArrayList<>(edgeNum);
        for(int i=0; i<vertexes.length-1; i++){
            for(int j=i+1; j<vertexes.length; j++){
                if(matrix[i][j] != INF){
                    Edge edge = new Edge(vertexes[i], vertexes[j], matrix[i][j]);
                    edgeList.add(edge);
                }
            }
        }
        Collections.sort(edgeList);
        return edgeList;
    }

    /**
     * 获取顶点的终点
     * @param i
     * @return
     */
    private int getVertexEnd(int i){
        while (ends[i] != 0 && ends[i]!=i){
            i = ends[i];
        }
        return i;
    }

    public void kruskal(){
        int index = 0;
        // 创建结果数据，保存最后的最小生成树
        List<Edge> rets = new ArrayList<>(vertexes.length-1);
        List<Edge> edgeList = getEdges();
        for(Edge edge : edgeList){
            int v1 = getPosition(edge.start);
            int v2 = getPosition(edge.end);
            int end1 = getVertexEnd(v1);
            int end2 = getVertexEnd(v2);
            // 如果边的两个顶点的终点相同，不能将边加入
            if(end1==end2){
                continue;
            }
            rets.add(edge);
            ends[end1] = end2;
            if(rets.size() == vertexes.length-1){
                break;
            }
        }
        System.out.println(Arrays.toString(rets.toArray()));
    }
}
