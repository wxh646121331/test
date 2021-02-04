//package com.wxh.alg.km;
//
//import org.jgrapht.graph.DefaultWeightedEdge;
//import org.jgrapht.graph.SimpleWeightedGraph;
//import org.junit.Test;
//
//import java.awt.geom.GeneralPath;
//import java.awt.geom.Line2D;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Set;
//import java.util.function.Supplier;
//
///**
// * @description:
// * @author: wuxinhong
// * @date: 2020/3/16
// * @time: 上午8:28
// * Copyright (C) 2020 MTDP
// * All rights reserved
// */
//public class KmTest {
//    @Test
//    public void test(){
////        int[][] weights = {{0, 9, 6, 4},{7, 10, 0, 1}, {8, 5, 4, 7}, {3, 7, 4, 1}};
////        int[][] weights = {{0, 7, 8, 3},{9, 10, 5, 7}, {6, 0, 4, 4}, {4, 1, 7, 1}};
//        int[][] weights = {{1,0}, {2,1}};
//        Vertex[] first = new Vertex[weights.length];
//        Vertex[] second = new Vertex[weights[0].length];
//        for(int i=0; i<weights.length; i++){
//            Vertex v = Vertex.Builder.newInstance().key(String.valueOf(i)).vertexType(VertexType.ROUTE).build();
//            first[i] = v;
//        }
//        for(int i=0; i<weights[0].length; i++){
//            Vertex v = Vertex.Builder.newInstance().key(String.valueOf(i)).vertexType(VertexType.TRANSPORT).build();
//            second[i] = v;
//        }
//
//        Km km = Km.Builder.newInstance().first(first).second(second).weights(weights).build();
//        km.match();
//        System.out.println(km.getMatchResult());
//        System.out.println(km.getTotalWeight());
//    }
//}
