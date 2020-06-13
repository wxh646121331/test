package com.wxh.alg.km;

import lombok.Getter;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;
import org.junit.Assert;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @description:
 * @author: wuxinhong
 * @date: 2020/3/16
 * @time: 上午11:15
 * Copyright (C) 2020 MTDP
 * All rights reserved
 */
public class Km {
    public static final int NO_MATCH_WEIGHT = 0;
    private static final int NO_MATCH_INDEX = -1;
    private Vertex[] x;
    private Vertex[] y;
    private SimpleWeightedGraph<Vertex, DefaultWeightedEdge> graph;
    @Getter
    private Set<DefaultWeightedEdge> matchResult;
    private boolean[] visitedX;
    private boolean[] visitedY;
    /**
     * 与 X 部中的顶点匹配的 Y 部顶点
     */
    private int[] linkX;
    /**
     * 与 Y 部中的顶点匹配的 X 部顶点
     */
    private int[] linkY;
    /**
     * X 部顶点边按权重从大到小排序
     */
    private Map<Vertex, List<DefaultWeightedEdge>> sortedEdgeListMap;

    /**
     * 结果总权重
     */
    @Getter
    private int totalWeight;

    /**
     * 顶点调整最小值
     */
    private int minZ;

    public void match(){
        for(int i=0; i<x.length; i++){
            Vertex vertex = x[i];
            if(CollectionUtils.isEmpty(sortedEdgeListMap.get(vertex))){
                continue;
            }
            while (true){
                minZ = Integer.MAX_VALUE;
                resetVisitedData();
                if(dfs(i)){
                    break;
                }
                if(minZ == Integer.MAX_VALUE){
                    break;
                }
                // 将交错树中 X 部顶点的顶标减去 minZ
                for(int j=0; j<x.length; j++){
                    if(visitedX[j]){
                        x[j].setValue(x[j].getValue()-minZ);
                    }
                }
                // 将交错树中 Y 部顶点的顶标加上 minZ
                for(int j=0; j<y.length; j++){
                    if(visitedY[j]){
                        y[j].setValue(y[j].getValue()+minZ);
                    }
                }
            }
        }
        for(int i=0; i<linkX.length; i++){
            if(linkX[i] == NO_MATCH_INDEX){
                continue;
            }
            DefaultWeightedEdge edge = graph.getEdge(x[i], y[linkX[i]]);
            matchResult.add(edge);
            totalWeight = totalWeight + (int)graph.getEdgeWeight(edge);
        }
    }

    boolean dfs(int s){
        Vertex vertexX = x[s];
        // X 部顶标降为0，将之前的匹配对释放
        if(vertexX.getValue()==NO_MATCH_WEIGHT){
            if(linkX[s]!=NO_MATCH_INDEX){
                linkY[linkX[s]] = NO_MATCH_INDEX;
                linkX[s] = NO_MATCH_INDEX;
            }
            return true;
        }
        visitedX[s] = true;
        List<DefaultWeightedEdge> edgeList = sortedEdgeListMap.get(vertexX);
        for(int i=0; i<edgeList.size(); i++){
            DefaultWeightedEdge edge = edgeList.get(i);
            Vertex vertexY = graph.getEdgeTarget(edge);
            int yIndex = vertexY.getIndex();
            if(!visitedY[yIndex]){
                int t = (int)(x[s].getValue() + y[yIndex].getValue() - graph.getEdgeWeight(edge));
                if(t<=0){
                    visitedY[yIndex] = true;
                    if(linkY[yIndex] == NO_MATCH_INDEX || dfs(linkY[yIndex])){
                        linkX[s] = yIndex;
                        linkY[yIndex] = s;
                        return true;
                    }else {
                        DefaultWeightedEdge edge1 = graph.getEdge(x[linkY[yIndex]], y[yIndex]);
                        if(graph.getEdgeWeight(edge) > graph.getEdgeWeight(edge1)){
                            linkX[linkY[yIndex]] = NO_MATCH_INDEX;
                            linkX[s] = yIndex;
                            linkY[yIndex] = s;
                            return true;
                        }
                    }
                }else if(t>0){
                    if(t<minZ){
                        minZ=t;
                    }
                }
            }
        }
        return false;
    }

    private void resetVisitedData(){
        for(int i=0; i<visitedX.length; i++){
            visitedX[i] = false;
        }
        for (int i=0; i<visitedY.length; i++){
            visitedY[i] = false;
        }
    }

    public static class Builder{
        private Vertex[] first;
        private Vertex[] second;
        private int[][] weights;

        public static Builder newInstance(){
            return new Builder();
        }

        public Builder first(Vertex[] first){
            this.first = first;
            return this;
        }

        public Builder second(Vertex[] second){
            this.second = second;
            return this;
        }

        public Builder weights(int[][] weights){
            this.weights = weights;
            return this;
        }

        public Km build(){
            Assert.assertTrue("first cannot be empty", null!=first && first.length>0);
            Assert.assertTrue("second cannot by empty", null!=second && second.length>0);
            Assert.assertTrue("weights cannot by empty", null != weights && weights.length>0);
            Assert.assertTrue("the length of weights does not match this size of first", first.length == weights.length);
            Assert.assertTrue("", second.length == weights[0].length);
            SimpleWeightedGraph<Vertex, DefaultWeightedEdge> graph = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);
            // X 部顶点加入二分图
            for(int i=0; i<first.length; i++){
                first[i].setIndex(i);
                graph.addVertex(first[i]);
            }
            // Y 部顶点加入二分图
            for(int i=0; i<second.length; i++){
                second[i].setIndex(i);
                graph.addVertex(second[i]);
            }
            // X 部顶点边集合
            Map<Vertex, List<DefaultWeightedEdge>> edgeListMap = new HashMap<>(first.length);
            // 将加权边加入二分图
            for(int i=0; i<first.length; i++){
                Vertex x = first[i];
                List<DefaultWeightedEdge> edgeList = new ArrayList<>();
                for(int j=0; j<second.length; j++){
                    int weight = weights[i][j];
                    if(weight == NO_MATCH_WEIGHT){
                        continue;
                    }
                    Vertex y = second[j];
                    DefaultWeightedEdge edge = graph.addEdge(x, y);
                    graph.setEdgeWeight(edge, weight);
                    // 为 X 部顶点设置顶标，顶标的值设置为最大边的权重
                    if(weight > x.getValue()){
                        x.setValue(weight);
                    }
                    edgeList.add(edge);
                }
                // 按权重排序
                edgeList.sort((e1, e2) -> graph.getEdgeWeight(e1) < graph.getEdgeWeight(e2) ? 1 : -1);
                edgeListMap.put(x, edgeList);
            }
            // 构建 km 对象
            Km km = new Km();
            km.x = first;
            km.y = second;
            km.graph = graph;
            km.linkX = new int[first.length];
            km.linkY = new int[second.length];
            for(int i=0; i<first.length; i++){
                km.linkX[i] = NO_MATCH_INDEX;
            }
            for(int i=0; i<second.length; i++){
                km.linkY[i] = NO_MATCH_INDEX;
            }
            km.visitedX = new boolean[first.length];
            km.visitedY = new boolean[second.length];
            km.sortedEdgeListMap = edgeListMap;
            km.matchResult = new HashSet<>();
            return km;
        }
    }
}
