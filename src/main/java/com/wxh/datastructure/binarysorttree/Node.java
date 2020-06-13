package com.wxh.datastructure.binarysorttree;

/**
 * @description:
 * @author: wuxinhong
 * @date: 2020/3/19
 * @time: 上午11:37
 * Copyright (C) 2020 MTDP
 * All rights reserved
 */
public class Node{
    int value;
    Node left;
    Node right;

    public Node(int value){
        this.value = value;
    }

    public void add(Node node){
        if(null == node){
            return;
        }
        if(node.value < this.value){
            if(left == null){
                this.left = node;
            }else {
                left.add(node);
            }
        }else {
            if(right == null){
                this.right = node;
            }else {
                right.add(node);
            }
        }
    }

    public void infixOrder(){
        if(left!=null){
            left.infixOrder();
        }
        System.out.println(this);
        if(right != null){
            right.infixOrder();
        }
    }

    public Node target(int value){
        if(this.value == value){
            return this;
        }
        if(value < this.value){
            if(left!=null){
                return left.target(value);
            }
        }else {
            if(right != null){
                return right.target(value);
            }
        }
        return null;
    }

    public Node parent(int value){
        if(this.value == value){
            return null;
        }
        if(this.left!=null && this.left.value == value){
            return this;
        }
        if(this.right!=null && this.right.value ==value){
            return this;
        }
        if(value<this.value && null!=left){
            return left.parent(value);
        }
        if(value>this.value && right!=null){
            return right.parent(value);
        }
        return null;
    }

    public int minValue(){
        if(left==null){
            return this.value;
        }
        return left.minValue();
    }

    public int maxValue(){
        if(right==null){
            return this.value;
        }
        return right.maxValue();
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }
}
