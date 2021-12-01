package com.wxh.leetcode;

/**
 * @author wuxinhong
 * @date 2021/11/19 2:17 下午
 */
public class Leetcode397 {
    public int integerReplacement(int n) {
        if(n == 1){
            return 0;
        }
        if(n == 2){
            return 1;
        }
        if(n % 2 == 0){
            return integerReplacement(n / 2) + 1;
        }else {
            return Math.min(integerReplacement(n + 1), integerReplacement(n - 1)) + 1;
        }
    }


    public int integerReplacement1(int n) {
        if(n == 1){
            return 0;
        }
        if(n == 2){
            return 1;
        }
        int count = 0;
        while ( n % 2 ==0){
            count ++;
            n = n/2;
        }
        if(n == 1){
            return count;
        }
        int res1 = integerReplacement1(((n -1) / 2) + 1) + 2 + count;
        int res2 = integerReplacement1(n-1) + count + 1;
        return Math.min(res1, res2);
    }

    public static void main(String[] args) {
        Leetcode397 leetcode397 = new Leetcode397();
//        System.out.println(leetcode397.integerReplacement(214748364));
        System.out.println(leetcode397.integerReplacement1(2147483647));
    }
}
