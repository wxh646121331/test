package com.wxh.datastructure.graph;

import org.junit.Test;

/**
 * @description:
 * @author: wuxinhong
 * @date: 2020/3/23
 * @time: 上午9:41
 * Copyright (C) 2020 MTDP
 * All rights reserved
 */
public class GraphDemo {
    public static void main(String[] args) {
        int n = 5;
        String[] vertexValue = {"A", "B", "C", "D", "E"};
        Graph graph = new Graph(n);
        for(String vertex : vertexValue){
            graph.insertVertex(vertex);
        }
        graph.insertEdge(0, 1, 1);
        graph.insertEdge(0, 2, 1);
        graph.insertEdge(1, 2, 1);
        graph.insertEdge(1, 3, 1);
        graph.insertEdge(1, 4, 1);
        graph.showGraph();
        graph.dfs();
        graph.bfs();
    }

    @Test
    public void test2(){
        int n = 8;
        String[] vertexValue = {"A", "B", "C", "D", "E", "F", "G", "H"};
        Graph graph = new Graph(n);
        for(String vertex : vertexValue){
            graph.insertVertex(vertex);
        }
        graph.insertEdge(0, 1, 1);
        graph.insertEdge(0, 2, 1);
        graph.insertEdge(1, 3, 1);
        graph.insertEdge(1, 4, 1);
        graph.insertEdge(3, 7, 1);
        graph.insertEdge(4, 7, 1);
        graph.insertEdge(2, 5, 1);
        graph.insertEdge(2, 6, 1);
        graph.insertEdge(5, 6, 1);
        graph.showGraph();
        graph.dfs();
        graph.bfs();
    }
}
