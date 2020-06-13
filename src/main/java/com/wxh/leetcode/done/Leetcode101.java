package com.wxh.leetcode.done;

import java.util.Stack;

/**
 * 对称二叉树：
 * 给定一个二叉树，检查它是否是镜像对称的。
 * 例如：二叉树 [1,2,2,3,4,4,3] 是对称的。
 * 但是[1,2,2,null,3,null,3] 则不是镜像对称的
 * 进阶：
 * 你可以运用递归和迭代两种方法解决这个问题吗？
 */
public class Leetcode101 {
    public static void main(String[] args) {
        int[] arr = {1,2,2,3,4,4,3};
        TreeNode root = new TreeNode(arr[0]);
        root.left = new TreeNode(arr[1]);
        root.right = new TreeNode(arr[2]);
        root.left.left = new TreeNode(arr[3]);
        root.left.right = new TreeNode(arr[4]);
        root.right.left = new TreeNode(arr[5]);
        root.right.right = new TreeNode(arr[6]);
        Leetcode101 leetcode101 = new Leetcode101();
        System.out.println(leetcode101.isSymmetric2(root));
    }

    public boolean isSymmetric(TreeNode root) {
        if(null == root){
            return true;
        }
        return isMirror(root.left, root.right);
    }

    public boolean isMirror(TreeNode left, TreeNode right){
        if(null==left && null==right){
            return true;
        }
        if(null==left || null==right){
            return false;
        }
        if(left.val != right.val){
            return false;
        }
        return isMirror(left.left, right.right) && isMirror(left.right, right.left);
    }

    public boolean isSymmetric2(TreeNode root) {
        if(null == root){
            return true;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root.left);
        stack.push(root.right);
        while (!stack.isEmpty()){
            TreeNode tree1 = stack.pop();
            TreeNode tree2 = stack.pop();
            if(null==tree1 && null==tree2){
                continue;
            }
            if(null==tree1 || null==tree2){
                return false;
            }
            if(tree1.val != tree2.val){
                return false;
            }
            stack.push(tree1.left);
            stack.push(tree2.right);
            stack.push(tree1.right);
            stack.push(tree2.left);
        }
        return true;
    }
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            this.val = x;;
        }
    }
}
