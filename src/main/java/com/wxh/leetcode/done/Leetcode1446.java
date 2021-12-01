package com.wxh.leetcode.done;

/**
 * @author wuxinhong
 * @date 2021/12/1 2:13 下午
 */
public class Leetcode1446 {
    public int maxPower(String s) {
        if(null == s || s.length()==0){
            return 0;
        }
        char[] chars = s.toCharArray();
        char curChar = chars[0];
        int curLen = 1;
        int max = 1;
        for(int i=1; i<chars.length; i++){
            if(chars[i] == curChar){
                curLen++;
            }else {
                if(curLen > max){
                    max = curLen;
                }
                curLen = 1;
                curChar = chars[i];
            }
        }
        return Math.max(max, curLen);
    }

    public static void main(String[] args) {
        Leetcode1446 leetcode1446 = new Leetcode1446();
        System.out.println(leetcode1446.maxPower("tourist"));
    }
}
