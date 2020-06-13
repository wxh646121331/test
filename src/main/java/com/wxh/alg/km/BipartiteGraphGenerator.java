package com.wxh.alg.km;

import lombok.Getter;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import java.util.List;

/**
 * @description:
 * @author: wuxinhong
 * @date: 2020/3/16
 * @time: 上午8:13
 * Copyright (C) 2020 MTDP
 * All rights reserved
 */
public class BipartiteGraphGenerator {
    @Getter
    private List<Vertex> first;
    @Getter
    private List<Vertex> second;

    private int[][] weights;

    public static BipartiteGraphGenerator newInstance(){
        return new BipartiteGraphGenerator();
    }

    public BipartiteGraphGenerator first(List<Vertex> first){
        this.first = first;
        return this;
    }

    public BipartiteGraphGenerator second(List<Vertex> second){
        this.second = second;
        return this;
    }

    public BipartiteGraphGenerator weights(int[][] weights){
        this.weights = weights;
        return this;
    }

    public SimpleWeightedGraph<Vertex, DefaultWeightedEdge> generateGraph(){
        SimpleWeightedGraph<Vertex, DefaultWeightedEdge> graph = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);
        for(Vertex v : first){
            graph.addVertex(v);
        }
        for(Vertex v : second){
            graph.addVertex(v);
        }
        for(int i=0; i<first.size(); i++){
            Vertex v1 = first.get(i);
            for(int j=0; j<second.size(); j++){
                if(weights[i][j]>0){
                    DefaultWeightedEdge edge = graph.addEdge(first.get(i), second.get(j));
                    graph.setEdgeWeight(edge, weights[i][j]);
                    if(weights[i][j] > v1.getValue()){
                        v1.setValue(weights[i][j]);
                    }
                }
            }
        }
        return graph;
    }
}
