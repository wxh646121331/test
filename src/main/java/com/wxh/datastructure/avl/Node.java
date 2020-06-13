package com.wxh.datastructure.avl;

/**
 * @description:
 * @author: wuxinhong
 * @date: 2020/3/20
 * @time: 上午9:53
 * Copyright (C) 2020 MTDP
 * All rights reserved
 */
public class Node {
    int value;
    Node left;
    Node right;

    public Node(int value){
        this.value = value;
    }

    public int leftHeight(){
        if(left == null){
            return 0;
        }
        return left.height();
    }

    public int rightHeight(){
        if(right == null){
            return 0;
        }
        return right.height();
    }

    void leftRotate(){
        // 创建新节点，值设置为当前节点的值
        Node newNode = new Node(value);
        // 新节点的左子树设置为当前节点的左子树
        newNode.left = left;
        // 新节点的右子树设置为当前节点的右子树的左子树
        newNode.right = right.left;
        // 当前节点的值设置为右子节点的值
        value = right.value;
        // 当前节点的右子树设置为右子树的右子树
        right = right.right;
        // 当前节点的左子节点设置为新节点
        left = newNode;
    }

    void rightRotate(){
        Node newNode = new Node(value);
        newNode.right = right;
        newNode.left = left.right;
        value = left.value;
        left = left.left;
        right = newNode;
    }

    public int height(){
        return Math.max(left==null ? 0 : left.height(), right==null ? 0 : right.height()) + 1;
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

        // 右子树的高度-左子树的高度 > 1，左旋转
        if(rightHeight() - leftHeight() > 1){
            if(right.leftHeight() < rightHeight()){
                right.rightHeight();
            }
            leftRotate();
        }

        // 左子树的高度-右子树的高度 > 1，右旋转
        if(leftHeight() - rightHeight() > 1){
            if(left.rightHeight() < leftHeight()){
                left.leftRotate();
            }
            rightRotate();
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
