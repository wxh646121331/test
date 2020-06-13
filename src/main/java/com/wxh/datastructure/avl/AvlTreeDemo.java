package com.wxh.datastructure.avl;

import org.junit.Test;

/**
 * @description:
 * @author: wuxinhong
 * @date: 2020/3/20
 * @time: 上午9:58
 * Copyright (C) 2020 MTDP
 * All rights reserved
 */
public class AvlTreeDemo {
    @Test
    public void test1(){
        int[] arr = {4,3,6,5,7,8};
        AvlTree avlTree = new AvlTree();
        for(int value : arr){
            avlTree.add(new Node(value));
        }
        avlTree.infixOrder();
        System.out.println("树的高度："+avlTree.root.height());
        System.out.println("左子树的高度："+avlTree.root.left.height());
        System.out.println("右子树的高度："+avlTree.root.right.height());
    }

    @Test
    public void test2(){
        int[] arr = {10,12,8,9,7,6};
        AvlTree avlTree = new AvlTree();
        for(int value : arr){
            avlTree.add(new Node(value));
        }
        avlTree.infixOrder();
        System.out.println("树的高度："+avlTree.root.height());
        System.out.println("左子树的高度："+avlTree.root.left.height());
        System.out.println("右子树的高度："+avlTree.root.right.height());
    }

    @Test
    public void test3(){
        int[] arr = {10,11,7,6,8,9};
        AvlTree avlTree = new AvlTree();
        for(int value : arr){
            avlTree.add(new Node(value));
        }
        avlTree.infixOrder();
        System.out.println("树的高度："+avlTree.root.height());
        System.out.println("左子树的高度："+avlTree.root.left.height());
        System.out.println("右子树的高度："+avlTree.root.right.height());
    }

}
