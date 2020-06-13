package com.wxh.datastructure.binarysorttree;

/**
 * @description:
 * @author: wuxinhong
 * @date: 2020/3/19
 * @time: 上午11:41
 * Copyright (C) 2020 MTDP
 * All rights reserved
 */
public class BinarySortTree {
    private Node root;
    public void add(Node node){
        if(root == null){
            root = node;
        }else {
            root.add(node);
        }
    }

    public void infixOrder(){
        if(null == root){
            return;
        }
        root.infixOrder();
    }

    public void delete(int value){
        Node target = root.target(value);
        if(target == null){
            System.out.println("节点不存在");
            return;
        }
        Node parent = root.parent(value);
        // 待删除节点无子节点
        if(target.left == null && target.right == null){
            if(parent == null){
                root = null;
                return;
            }
            if(parent.left == target){
                parent.left = null;
                return;
            }
            if(parent.right == target){
                parent.right = null;
                return;
            }
        }

        // 待删除节点只有一个左子节点
        if(target.left != null && target.right == null){
            if(parent == null){
                int maxValue = target.left.maxValue();
                delete(maxValue);
                target.value = maxValue;
                return;
            }
            if(parent.left == target){
                parent.left = target.left;
                return;
            }
            if(parent.right == target){
                parent.right = target.left;
                return;
            }
        }
        // 待删除节点只有一个右子节点
        if(target.right!=null && target.left==null){
            if(parent == null){
                int minValue = target.right.minValue();
                delete(minValue);
                target.value = minValue;
                return;
            }
            if(parent.left == target){
                parent.left = target.right;
                return;
            }
            if(parent.right == target){
                parent.right = target.right;
                return;
            }
        }

        //待删除节点有两个子节点
        if(target.right!=null && target.left!=null){
            int minValue = target.right.minValue();
            delete(minValue);
            target.value = minValue;
            return;
        }
    }
}
