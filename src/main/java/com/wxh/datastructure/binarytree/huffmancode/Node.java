package com.wxh.datastructure.binarytree.huffmancode;

/**
 * @description:
 * @author: wuxinhong
 * @date: 2020/3/18
 * @time: 下午10:20
 * Copyright (C) 2020 MTDP
 * All rights reserved
 */
public class Node implements Comparable<Node>{
    Byte data;
    int weight;
    Node left;
    Node right;
    Node(Byte data, int weight){
        this.data = data;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        return this.weight - o.weight;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", weight=" + weight +
                '}';
    }

    public void preOrder(){
        if(null==left && null==right){
            System.out.println(this);
        }
        if(left!=null){
            left.preOrder();
        }
        if(right!=null){
            right.preOrder();
        }
    }
}
