package com.wxh.algorithm.floyd;

import java.util.Arrays;

/**
 * @description:
 * @author: wuxinhong
 * @date: 2020/4/5
 * @time: 上午12:19
 * Copyright (C) 2020 MTDP
 * All rights reserved
 */
public class Graph {
    private char[] vertex;
    private int[][] dis;
    /* 保存到达目标标点的前驱顶点 */
    private int[][] pre;

    public Graph(int length, int[][] matrix, char[] vertex){
        this.vertex = vertex;
        this.dis = matrix;
        this.pre = new int[length][length];
        for(int i=0; i<length; i++){
            Arrays.fill(pre[i], i);
        }
    }

    public void show(){
        showDis();
        System.out.println();
        showPre();
    }

    private void showDis(){
        System.out.println("距离矩阵为：");
        System.out.print("      ");
        for(char c : vertex){
            System.out.printf("%5s ",c);
        }
        System.out.println();
        for(int i=0; i<vertex.length; i++){
            System.out.printf("%5s ", vertex[i]);
            for(int j=0; j<vertex.length; j++){
                System.out.printf("%5d ", dis[i][j]);
            }
            System.out.println();
        }
    }

    private void showPre(){
        System.out.println("前驱矩阵为：");
        System.out.print("      ");
        for(char c : vertex){
            System.out.printf("%5s ",c);
        }
        System.out.println();
        for(int i=0; i<vertex.length; i++){
            System.out.printf("%5s ", vertex[i]);
            for(int j=0; j<vertex.length; j++){
                System.out.printf("%5d ", pre[i][j]);
            }
            System.out.println();
        }
    }

    public void floyd(){
        for(int i=0; i<vertex.length; i++){
            for(int j=0; j<vertex.length; j++){
                for(int k=0; k<vertex.length; k++){
                    int temp = dis[i][j] + dis[i][k];
                    if(temp < dis[j][k]){
                        dis[j][k] = temp;
                        dis[k][j] = temp;
                        pre[j][k] = i;
                        pre[k][j] = i;
                    }
                }
            }
        }
    }
}
