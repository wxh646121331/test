package com.wxh.datastructure.binarytree.huffman;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @description:
 * @author: wuxinhong
 * @date: 2020/3/18
 * @time: 下午9:40
 * Copyright (C) 2020 MTDP
 * All rights reserved
 */
public class HuffmanTree {
    public static void main(String[] args) {
        int[] arr = {13, 7, 8, 3, 29, 6, 1};
        Node node = createHuffmanTree(arr);
        node.preOrder();
    }

    public static Node createHuffmanTree(int[] arr){
        List<Node> nodeList = new ArrayList<>(arr.length);
        for(int value : arr){
            nodeList.add(new Node(value));
        }
        while (true){
            if(nodeList.size() == 1){
                break;
            }
            Collections.sort(nodeList);
            Node left = nodeList.get(0);
            Node right = nodeList.get(1);
            Node parent = new Node(left.value+right.value);
            parent.left = left;
            parent.right = right;
            nodeList.remove(left);
            nodeList.remove(right);
            nodeList.add(parent);
        }
        return nodeList.get(0);
    }
}
