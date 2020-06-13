package com.wxh.datastructure.binarytree;

import com.sun.javaws.IconUtil;
import lombok.Getter;
import lombok.Setter;

/**
 * @description:
 * @author: wuxinhong
 * @date: 2020/3/17
 * @time: 下午11:18
 * Copyright (C) 2020 MTDP
 * All rights reserved
 */
public class ThreadedBinaryTreeDemo {
    public static void main(String[] args) {
        Node root = new Node(1, "tom1");
        Node node2 = new Node(3, "tom2");
        Node node3 = new Node(6, "tom3");
        Node node4 = new Node(8, "tom4");
        Node node5 = new Node(10, "tom5");
        Node node6 = new Node(14, "tom6");
        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);
        ThreadedBinaryTree threadedBinaryTree = new ThreadedBinaryTree();
        threadedBinaryTree.setRoot(root);
        threadedBinaryTree.threadedNodes();
        System.out.println(node4);
        System.out.println(node4.getLeft());
        threadedBinaryTree.threadedList();
        threadedBinaryTree.threadedList1();
    }
}

class ThreadedBinaryTree{
    private Node root;
    /**
     * 为了实现线索化，需要创建一个指向当前节点的前驱节点的指针
     */
    private Node pre;

    public void setRoot(Node root){
        this.root = root;
    }

    public void threadedNodes(){
        threadedNodes(root);
    }

    public void threadedList(){
        threadedList(root);
    }

    public void threadedList1(){
        Node node = root;
        while (node != null){
            while (node.getLeftType()==0 && node.getLeft()!=null){
                node = node.getLeft();
            }
            System.out.println(node);
            if(node.getRightType()==1){
                node = node.getRight();
                System.out.println(node);
            }
            node = node.getRight();
        }
    }

    public void threadedList(Node node){
        if(null == node){
            return;
        }
        if(node.getLeftType() == 0 && node.getLeft()!=null){
            threadedList(node.getLeft());
        }
        System.out.println(node);
        if(node.getRightType() == 0 && node.getRight()!=null){
            threadedList(node.getRight());
        }
    }

    public void threadedNodes(Node node){
        if(node == null){
            return;
        }
        // 线索化左子树
        threadedNodes(node.getLeft());
        // 线索化当前节点
        if(node.getLeft() == null){
            node.setLeftType(1);
            node.setLeft(pre);
        }
        if(pre!=null && pre.getRight()==null){
            pre.setRightType(1);
            pre.setRight(node);
        }
        pre = node;
        // 线索化右子树
        threadedNodes(node.getRight());
    }
}

@Getter
@Setter
class Node{
    private int no;
    private String name;
    private Node left;
    private Node right;
    private int leftType;
    private int rightType;

    public Node(int no, String name){
        this.no = no;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Node{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", leftType=" + leftType +
                ", rightType=" + rightType +
                '}';
    }

    /**
     * 前序遍历
     */
    public void preOrder(){
        System.out.println(this);
        // 递归向左子树前序遍历
        if(null != this.left){
            this.left.preOrder();
        }
        // 递归向右子树前序遍历
        if(null != this.right){
            this.right.preOrder();
        }
    }

    public void infixOrder(){
        // 递归向左子树前序遍历
        if(null != this.left){
            this.left.preOrder();
        }
        System.out.println(this);
        // 递归向右子树前序遍历
        if(null != this.right){
            this.right.preOrder();
        }
    }

    public void postOrder(){
        // 递归向左子树前序遍历
        if(null != this.left){
            this.left.preOrder();
        }
        // 递归向右子树前序遍历
        if(null != this.right){
            this.right.preOrder();
        }
        System.out.println(this);
    }
}
