package com.wxh.jgrapht;

import org.jgrapht.Graph;
import org.jgrapht.generate.CompleteGraphGenerator;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleDirectedGraph;
import org.jgrapht.graph.SimpleGraph;
import org.jgrapht.graph.SimpleWeightedGraph;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class GraphTest {

    /**
     * 无向图
     */
    @Test
    public void test1(){
        Graph<String, DefaultEdge> graph = new SimpleGraph<>(DefaultEdge.class);
        String v1 = "v1";
        String v2 = "v2";
        graph.addVertex(v1);
        graph.addVertex(v2);
        graph.addEdge(v1, v2);
        graph.addEdge(v2, v1);
        System.out.println(graph);
    }

    /**
     * 有向图
     */
    @Test
    public void test2(){
        SimpleDirectedGraph<String, DefaultEdge> directedGraph = new SimpleDirectedGraph<>(DefaultEdge.class);
        String v1 = "v1";
        String v2 = "v2";
        String v3 = "v3";
        directedGraph.addVertex(v1);
        directedGraph.addVertex(v2);
        directedGraph.addVertex(v3);
        directedGraph.addEdge(v1, v2);
        directedGraph.addEdge(v2, v1);
        System.out.println(directedGraph);
    }

    /**
     * 带权图
     */
    @Test
    public void test3(){
        SimpleWeightedGraph<String, DefaultWeightedEdge> graph = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);
        String v1 = "v1";
        String v2 = "v2";
        String v3 = "v3";
        graph.addVertex(v1);
        graph.addVertex(v2);
        graph.addVertex(v3);
        DefaultWeightedEdge edge1 = graph.addEdge(v1, v2);
        graph.setEdgeWeight(edge1, 10);
        System.out.println(graph);

    }

    @Test
    public void test4(){
        Generator<String> generator = new Generator<>();
        String v1 = "v1";
        String v2 = "v2";
        String v3 = "v3";
        List<String> a = new ArrayList<>();
        List<String> b = new ArrayList<>();
        a.add(v1);
        b.add(v2);
        b.add(v3);
        generator.x(a);
        generator.y(b);
        System.out.println(b.size());
        int[][] weights = new int[a.size()][b.size()];
        weights[0][0] = 1;
        System.out.println(weights.length);
        generator.weights(weights);
        SimpleWeightedGraph<String, DefaultWeightedEdge> graph = generator.generate();
        System.out.println(graph);
        DefaultWeightedEdge edge = graph.getEdge(v2, v1);
        System.out.println(edge);
        graph.getEdgeWeight(edge);
        System.out.println(graph.getEdgeWeight(edge));
    }

    public static class Generator<V>{
        List<V> x;
        List<V> y;
        int[][] weights;

        public Generator x(List<V> x){
            this.x = x;
            return this;
        }

        public Generator y(List<V> y){
            this.y = y;
            return this;
        }

        public Generator weights(int[][] weights){
            this.weights = weights;
            return this;
        }

        public SimpleWeightedGraph generate(){
            SimpleWeightedGraph<V, DefaultWeightedEdge> graph = new SimpleWeightedGraph<V, DefaultWeightedEdge>(DefaultWeightedEdge.class);
            for(V v : x){
                graph.addVertex(v);
            }
            for(V v : y){
                graph.addVertex(v);
            }
            for(int i=0; i<x.size(); i++){
                for(int j=0; j<y.size(); j++){
                    DefaultWeightedEdge edge = graph.addEdge(x.get(i), y.get(j));
                    graph.setEdgeWeight(edge, weights[i][j]);
                }
            }
            return graph;
        }
    }



    /**
     * 完整图
     */
    @Test
    public void test5(){
        SimpleWeightedGraph<String, DefaultEdge> graph = new SimpleWeightedGraph<>(DefaultEdge.class);
        CompleteGraphGenerator<String, DefaultEdge> completeGraphGenerator = new CompleteGraphGenerator<>(10);
        completeGraphGenerator.generateGraph(graph, null);
        System.out.println(graph);
    }

    public void test6(){
//        DijkstraShortestPath dijkstraShortestPath
//                = new DijkstraShortestPath(directedGraph);
//        List<String> shortestPath = dijkstraShortestPath
//                .getPath("v1","v4").getVertexList();
//        System.out.println(shortestPath);

//        BellmanFordShortestPath bellmanFordShortestPath
//                = new BellmanFordShortestPath(directedGraph);
//        List<String> shortestPath = bellmanFordShortestPath
//                .getPath("v1", "v4")
//                .getVertexList();

    }


}
