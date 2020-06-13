package com.wxh.datastructure.binarytree.huffman;

import lombok.Getter;
import lombok.Setter;

/**
 * @description:
 * @author: wuxinhong
 * @date: 2020/3/18
 * @time: 下午9:40
 * Copyright (C) 2020 MTDP
 * All rights reserved
 */
@Getter
@Setter
public class Node implements Comparable<Node> {
    int value;
    Node left;
    Node right;

    public Node(int value){
        this.value = value;
    }

    public void preOrder(){
        if(null == left && right==null){
            System.out.println(this);
        }
        if(null != left){
            left.preOrder();
        }
        if(null != right){
            right.preOrder();
        }
    }
    @Override
    public int compareTo(Node o) {
        return this.value - o.value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }
}
