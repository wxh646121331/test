package com.wxh.leetcode.done;

/**
 * @author wuxinhong
 * @date 2021/7/24 10:04 下午
 */
public class Leetcode1736 {
    public static String maximumTime(String time) {
        char c1 = time.charAt(0);
        char c2 = time.charAt(1);
        char c3 = time.charAt(3);
        char c4 = time.charAt(4);
        if(c1 == '?'){
            if(c2 == '?' || c2 < '4'){
                c1 = '2';
            }else {
                c1 = '1';
            }
        }
        if(c2 == '?'){
            if(c1 == '2'){
                c2 = '3';
            }else {
                c2 = '9';
            }
        }
        if(c3 == '?'){
            c3 = '5';
        }
        if(c4 == '?'){
            c4 = '9';
        }
        StringBuilder sb = new StringBuilder();
        sb.append(c1).append(c2).append(":").append(c3).append(c4);
        return sb.toString();
    }


    public static void main(String[] args) {
        String time = "1?:22";
        System.out.println(maximumTime(time));
    }
}
