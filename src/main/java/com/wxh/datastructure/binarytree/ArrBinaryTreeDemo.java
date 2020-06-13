package com.wxh.datastructure.binarytree;

public class ArrBinaryTreeDemo {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        ArrBinaryTree arrBinaryTree = new ArrBinaryTree(arr);
        arrBinaryTree.preOrder();
    }

    static class ArrBinaryTree{
        private int[] arr;
        public ArrBinaryTree(int[] arr){
            this.arr = arr;
        }

        public void preOrder(){
            preOrder(0);
        }

        public void preOrder(int index){
            if(null == arr || arr.length==0 ){
                System.out.println("数组为空，不能按照二叉树的前序遍历");
                return;
            }
            System.out.println(arr[index]);
            if(2*index +1 < arr.length){
                preOrder(2*index +1);
            }
            if(2*index+2 < arr.length){
                preOrder(2*index+2);
            }
        }
    }
}
