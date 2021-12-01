package com.wxh.leetcode.done;

/**
 * @author wuxinhong
 * @date 2021/7/27 10:43 下午
 */
public class Leetcode344 {
    public void reverseString(char[] s) {
        char temp;
        for(int i=0; i<s.length / 2; i++){
            temp = s[i];
            s[i] = s[s.length-1-i];
            s[s.length-1-i] = temp;
        }
    }
}
