package com.wxh.datastructure.binarytree;

import lombok.Getter;
import lombok.Setter;

public class BinaryTreeDemo {
    public static void main(String[] args) {
        // 创建一棵二叉树
        BinaryTree binaryTree = new BinaryTree();
        // 创建节点
        HeroNode root = new HeroNode(1, "宋江");
        HeroNode node2 = new HeroNode(2, "吴用");
        HeroNode node3 = new HeroNode(3, "卢俊义");
        HeroNode node4 = new HeroNode(4, "林冲");

        root.setLeft(node2);
        root.setRight(node3);
        node3.setRight(node4);

        binaryTree.setRoot(root);
        System.out.println("前序遍历：");
        binaryTree.preOrder();
        System.out.println("中序遍历");
        binaryTree.infixOrder();
        System.out.println("后序遍历");
        binaryTree.postOrder();
    }
}

class BinaryTree{
    private HeroNode root;

    public void setRoot(HeroNode root){
        this.root = root;
    }

    public void preOrder(){
        if(this.root != null){
            this.root.preOrder();
        }else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    public void infixOrder(){
        if(this.root != null){
            this.root.infixOrder();
        }else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    public void postOrder(){
        if(this.root != null){
            this.root.postOrder();
        }else {
            System.out.println("二叉树为空，无法遍历");
        }
    }
}

@Getter
@Setter
class HeroNode{
    private int no;
    private String name;
    private HeroNode left;
    private HeroNode right;

    public HeroNode(int no, String name){
        this.no = no;
        this.name = name;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
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

