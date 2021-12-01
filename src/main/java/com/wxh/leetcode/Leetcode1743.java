package com.wxh.leetcode;

import java.util.LinkedList;

/**
 * @author wuxinhong
 * @date 2021/7/26 9:09 上午
 */
public class Leetcode1743 {
    public int[] restoreArray(int[][] adjacentPairs) {
        LinkedList<Integer> linkList = new LinkedList<>();
        boolean[] isVisited = new boolean[adjacentPairs.length];
        if(adjacentPairs[0][0] > adjacentPairs[0][1]){
            linkList.addFirst(adjacentPairs[0][0]);
            linkList.addFirst(adjacentPairs[0][1]);
        }else {
            linkList.addFirst(adjacentPairs[0][1]);
            linkList.addFirst(adjacentPairs[0][0]);
        }
        int start = 1;
        isVisited[0] = true;
        while (start < adjacentPairs.length){
            start = search(linkList, adjacentPairs, isVisited, start);
        }
        int[] result = new int[linkList.size()];
        for(int i=0; i<linkList.size(); i++){
            result[i] = linkList.get(i);
        }
        return result;
    }

    private int search(LinkedList<Integer> linkList, int[][] adjacentPairs, boolean[] isVisited, int start){
        int nextStart = Integer.MAX_VALUE;
        int first = linkList.getFirst();
        int last = linkList.getLast();
        for(int i=start; i<adjacentPairs.length; i++){
            if(isVisited[i]){
                continue;
            }
            if(adjacentPairs[i][0] == first){
                linkList.addFirst(adjacentPairs[i][1]);
                isVisited[i] = true;
            }else if(adjacentPairs[i][1] == first){
                linkList.addFirst(adjacentPairs[i][0]);
                isVisited[i] = true;
            }else if(adjacentPairs[i][0] == last){
                linkList.addLast(adjacentPairs[i][1]);
                isVisited[i] = true;
            }else if(adjacentPairs[i][1] == last){
                linkList.addLast(adjacentPairs[i][0]);
                isVisited[i] = true;
            }else {
                if(nextStart > i){
                    nextStart = i;
                }
            }
        }
        return nextStart;
    }
}
