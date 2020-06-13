package com.wxh.algorithm.kruskal;

/**
 * @description:
 * @author: wuxinhong
 * @date: 2020/3/27
 * @time: 上午10:01
 * Copyright (C) 2020 MTDP
 * All rights reserved
 */
public class Edge implements Comparable<Edge>{
    char start;
    char end;
    int weight;

    public Edge(char start, char end, int weight){
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "<" + start +
                ", " + end +
                ">=" + weight +
                '}';
    }

    @Override
    public int compareTo(Edge o) {
        return this.weight - o.weight;
    }
}
