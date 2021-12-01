package com.wxh.leetcode.done;

/**
 * 给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为 2 或 0。如果一个节点有两个子节点的话，那么该节点的值等于两个子节点中较小的一个。
 * 更正式地说，root.val = min(root.left.val, root.right.val) 总成立。
 * 给出这样的一个二叉树，你需要输出所有节点中的第二小的值。如果第二小的值不存在的话，输出 -1 。
 * @author wuxinhong
 * @date 2021/7/27 11:27 上午
 */
public class Leetcode671 {
    public int findSecondMinimumValue(TreeNode root) {
        if(null == root || root.left == null){
            return -1;
        }

        if(root.left.val < root.right.val){
            int left = findSecondMinimumValue(root.left);
            if(left == -1){
                return root.right.val;
            }else {
                return Math.min(left, root.right.val);
            }
        }
        if(root.left.val > root.right.val){
            int right = findSecondMinimumValue(root.right);
            if(right == -1){
                return root.left.val;
            }else {
                return Math.min(root.left.val, right);
            }
        }
        int left = findSecondMinimumValue(root.left);
        int right = findSecondMinimumValue(root.right);
        if(left == -1){
            return right;
        }
        if(right == -1){
            return left;
        }
        return Math.min(left, right);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
