package com.wxh.algorithm.dijkstra;

import com.sun.javaws.IconUtil;

import java.util.Arrays;

/**
 * @description:
 * @author: wuxinhong
 * @date: 2020/3/27
 * @time: 下午9:50
 * Copyright (C) 2020 MTDP
 * All rights reserved
 */
public class VisitedVertex {
    boolean[] alreadyArr;
    int[] preVisited;
    int[] dis;

    /**
     *
     * @param length 顶点的个数
     * @param start 初始顶点对应的下标
     */
    public VisitedVertex(int length, int start){
        this.alreadyArr = new boolean[length];
        this.preVisited = new int[length];
        this.dis = new int[length];
        // 初始化dis数组，与其它顶点距离设置为无穷大，与本身距离设置为0
        Arrays.fill(dis, DijkstraAlgorithm.N);
        dis[start] = 0;
        this.alreadyArr[start] = true;
    }

    /**
     * 判断 index 顶点是否被访问过
     * @param index
     * @return
     */
    public boolean isVisited(int index){
        return alreadyArr[index];
    }

    /**
     * 更新初始顶点到index顶点的距离
     * @param index
     * @param len
     */
    public void updateDis(int index, int len){
        dis[index] = len;
    }

    /**
     * 更新index顶点的前驱顶点为pre
     * @param index
     * @param pre
     */
    public void updatePre(int index, int pre){
        preVisited[index] = pre;
    }

    /**
     * 初始顶点到index顶点的距离
     * @param index
     * @return
     */
    public int getDis(int index){
        return dis[index];
    }

    public int updateArr(){
        int min = DijkstraAlgorithm.N;
        int index = 0;
        for(int i=0; i<alreadyArr.length; i++){
            if(!alreadyArr[i] && dis[i]<min){
                min = dis[i];
                index = i;
            }
        }
        alreadyArr[index] = true;
        return index;
    }

    public void show(){
        System.out.println("================");
        for(boolean b: alreadyArr){
            System.out.print(b+ " ");
        }
        System.out.println();
        for(int i : preVisited){
            System.out.print(i+" ");
        }
        System.out.println();
        for (int i : dis){
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
