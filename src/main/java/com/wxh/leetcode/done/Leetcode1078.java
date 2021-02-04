//package com.wxh.leetcode.done;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import java.util.Stack;
//
///**
// *
// */
//public class Leetcode1078 {
//
//    public static void main(String[] args) {
//        String text = "we will we will rock you";
//        String first = "we";
//        String second = "will";
//        Leetcode1078 leetcode1078 = new Leetcode1078();
//        String[] res = leetcode1078.findOcurrences(text, first, second);
//        System.out.println(Arrays.toString(res));
//    }
//
//    public String[] findOcurrences(String text, String first, String second) {
//        String[] sub = text.split(" ");
//        List<Integer> indexs = new ArrayList<>();
//        Stack<String> stack = new Stack<>();
//        for(int i=0; i<sub.length; i++){
//            if(stack.isEmpty()){
//                if(sub[i].equals(first)){
//                    stack.push(sub[i]);
//                }
//            }else if(stack.size() == 1){
//                if(sub[i].equals(second)){
//                    stack.push(second);
//                }else {
//                    stack.pop();
//                    if(sub[i].equals(first)){
//                        stack.push(sub[i]);
//                    }
//                }
//            }else {
//                indexs.add(i);
//                stack.pop();
//                stack.pop();
//                if(sub[i].equals(first)){
//                    stack.push(sub[i]);
//                }
//            }
//        }
//        String[] res = new String[indexs.size()];
//        for(int i=0; i<indexs.size(); i++){
//            res[i] = sub[indexs.get(i)];
//        }
//        return res;
//    }
//}
