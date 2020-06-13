package com.wxh.datastructure.binarysorttree;

/**
 * @description:
 * @author: wuxinhong
 * @date: 2020/3/19
 * @time: 上午11:37
 * Copyright (C) 2020 MTDP
 * All rights reserved
 */
public class BinarySortTreeDemo {
    public static void main(String[] args) {
        int[] arr = {7, 3, 10, 12, 5, 1, 9};
        BinarySortTree tree = new BinarySortTree();
        for(int value : arr){
            tree.add(new Node(value));
        }
//        tree.infixOrder();
        tree.delete(10);
        tree.delete(9);
        tree.delete(7);
        tree.delete(12);
        tree.delete(1);
        tree.delete(5);
        tree.delete(3);
        tree.infixOrder();
    }
}
