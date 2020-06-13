package com.wxh.leetcode.done;

import java.util.Stack;

/**
 * 84. 柱状图中最大的矩形
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 * 求解思路：单调栈
 */
public class Leetcode84 {
    public static void main(String[] args) {
        Leetcode84 leetcode84 = new Leetcode84();
        int[] heights = {5,5,1,7,1,1,5,2,7,6};
        int max = leetcode84.largestRectangleAreaWithStack(heights);
        System.out.println(max);
        int max1 = leetcode84.largestRectangleArea(heights);
        System.out.println(max1);
    }

    /**
     * 暴力法，时间复杂度：n^2，有待优化
     * @param heights
     * @return
     */
    public int largestRectangleArea(int[] heights) {
        int max = 0;
        for(int i=1; i<=heights.length; i++){
            int temp = largestRectangleArea(heights, i);
            if(temp > max){
                max = temp;
            }
        }
        return max;
    }

    private int largestRectangleArea(int[] heights, int n){
        int maxMin = 0;
        for(int i=0; i<=heights.length-n; i++){
            int min = heights[i];
            for(int j=i+1; j<i+n; j++){
                if(heights[j] < min){
                    min = heights[j];
                }
            }
            if(min > maxMin){
                maxMin = min;
            }
        }
        return maxMin * n;
    }

    public int largestRectangleAreaWithStack(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int max = 0;
        for(int i=0; i<heights.length; i++){
            if(stack.peek()<0 || heights[stack.peek()]<=heights[i]){
                stack.push(i);
                continue;
            }
            while (true){
                int index = stack.pop();
                int area = (i-stack.peek()-1) * heights[index];
                if(area > max){
                    max = area;
                }
                if(stack.peek()<0 || heights[stack.peek()] < heights[i]){
                    break;
                }
            }
            stack.push(i);
        }
        if(stack.peek() < 0){
            return max;
        }
        int maxIndex = stack.pop();
        int area = (maxIndex - stack.peek()) * heights[maxIndex];
        if(area > max){
            max = area;
        }
        while (stack.peek()>=0){
            int index = stack.pop();
            area = (maxIndex - stack.peek()) * heights[index];
            if(area > max){
                max = area;
            }
        }
        return max;
    }
}
