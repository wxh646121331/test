package com.wxh.leetcode.done;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *
 * @author wuxinhong
 * @date 2021/3/5 9:12 上午
 */
public class Leetcode782 {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        PriorityQueue<Node> queue = new PriorityQueue<>(k, Comparator.reverseOrder());
        for(int i=0; i<arr.length-1; i++){
            for(int j=i+1; j<arr.length; j++){
                Node node = new Node(arr[i], arr[j]);
                if(queue.size() < k){
                    queue.add(node);
                }else {
                    if(node.compareTo(queue.peek()) < 0){
                        queue.poll();
                        queue.add(node);
                    }
                }
            }
        }
        Node peek = queue.peek();
        int[] res = new int[2];
        res[0] = peek.valI;
        res[1] = peek.valJ;
        return res;
    }

    static class Node implements Comparable<Node>{
        int valI;
        int valJ;

        public Node(int valI, int valJ){
            this.valI = valI;
            this.valJ = valJ;
        }

        @Override
        public int compareTo(Node o) {
            int x = valI * o.valJ;
            int y = o.valI * valJ;
            return (x < y) ? -1 : ((x == y) ? 0 : 1);
        }
    }

    public static void main(String[] args) {
        Leetcode782 leetcode782 = new Leetcode782();
        int[] arr = new int[]{1,2,3,5};
        int[] res = leetcode782.kthSmallestPrimeFraction(arr, 5);
        System.out.println("i="+res[0]+",j="+res[1]);
    }
}
