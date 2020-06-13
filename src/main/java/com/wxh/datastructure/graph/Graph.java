package com.wxh.datastructure.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @description:
 * @author: wuxinhong
 * @date: 2020/3/23
 * @time: 上午9:36
 * Copyright (C) 2020 MTDP
 * All rights reserved
 */
public class Graph {
    /**
     * 存储顶点集合
     */
    private ArrayList<String> vertexList;
    /**
     * 存储图对应的邻接矩阵
     */
    private int[][] edges;
    /**
     * 表示边的数目
     */
    private int numOfEdges;

    /**
     * 节点是否被访问
     */
    private boolean[] isVisited;

    public Graph(int n){
        edges = new int[n][n];
        vertexList = new ArrayList<>(n);
        numOfEdges = 0;
        isVisited = new boolean[n];
    }

    /**
     * 添加顶点
     * @param vertex
     */
    public void insertVertex(String vertex){
        vertexList.add(vertex);
    }

    /**
     * 往图中添加边
     * @param v1
     * @param v2
     * @param weight
     */
    public void insertEdge(int v1, int v2, int weight){
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numOfEdges++;
    }

    public int getNumOfVertex(){
        return vertexList.size();
    }

    public int getNumOfEdges(){
        return numOfEdges;
    }

    public String getValueByIndex(int i){
        return vertexList.get(i);
    }

    public int getWeight(int v1, int v2){
        return edges[v1][v2];
    }

    public void showGraph(){
        for(int[] link : edges){
            System.out.println(Arrays.toString(link));
        }
    }

    public void dfs(){
        System.out.println("深度优先遍历结果");
        for(int i=0; i<vertexList.size(); i++){
            if(!isVisited[i]){
                dfs(i);
            }
        }
    }

    public void dfs(int v){
        System.out.println(vertexList.get(v));
        isVisited[v] = true;
        int w = getFirstNeighbor(v);
        while (true){
            if(w<0){
                return;
            }
            if(!isVisited[w]){
                dfs(w);
            }
            w = getNextNeighbor(v, w);
        }
    }

    public void bfs(){
        System.out.println("广度优先遍历结果：");
        isVisited = new boolean[vertexList.size()];
        for(int i=0; i<vertexList.size(); i++){
            if(!isVisited[i]){
                bfs(isVisited, i);
            }
        }
    }

    public void bfs(boolean[] isVisited, int v){
        // 队列头节点下标
        int u;
        // 邻接节点下标
        int w;
        LinkedList<Integer> queue = new LinkedList<>();
        System.out.print(getValueByIndex(v) + "=>");
        isVisited[v] = true;
        queue.addLast(v);
        while (!queue.isEmpty()){
            u = queue.removeFirst();
            w = getFirstNeighbor(u);
            while (w!=-1){
                if(!isVisited[w]){
                    System.out.print(getValueByIndex(w) + "=>");
                    isVisited[w] = true;
                    queue.addLast(w);
                }
                w = getNextNeighbor(u, w);
            }
        }
    }

    /**
     * 根据前一个邻接节点的下标来获取下一个邻接节点
     */
    public int getNextNeighbor(int v1, int v2){
        for(int j = v2+1; j<vertexList.size(); j++){
            if(edges[v1][j] > 0){
                return j;
            }
        }
        return -1;
    }

    /**
     * 得到第一个邻接节点的下标w
     */
    public int getFirstNeighbor(int index){
        for(int j=0; j<this.vertexList.size(); j++){
            if(edges[index][j] > 0){
                return j;
            }
        }
        return -1;
    }
}
