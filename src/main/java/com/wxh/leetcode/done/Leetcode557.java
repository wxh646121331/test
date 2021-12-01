package com.wxh.leetcode.done;

/**
 * @author wuxinhong
 * @date 2021/7/27 10:46 下午
 */
public class Leetcode557 {
    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        int start=0;
        int end;
        for(int i=0; i<s.length(); i++){
            if(chars[i] == ' '){
                end = i-1;
                reverse(chars, start, end);
                start = i+1;
            }else if(i == s.length()-1){
                end = i;
                reverse(chars, start, end);
            }
        }
        return String.valueOf(chars);
    }

    private void reverse(char[] chars, int start, int end){
        char temp;
        while (start < end){
            temp = chars[start];
            chars[start++] = chars[end];
            chars[end--] = temp;
        }
    }

    public static void main(String[] args) {
        Leetcode557 leetcode557 = new Leetcode557();
        System.out.println(leetcode557.reverseWords("Let's take LeetCode contest"));
    }
}
