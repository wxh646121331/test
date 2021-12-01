package com.wxh.leetcode.done;

/**
 * @author wuxinhong
 * @date 2021/11/30 3:11 下午
 */
public class Leetcode400 {
    public int findNthDigit(int n) {
        int zone = findZone(n);
        for(int i=1; i<zone; i++){
            int count = 9 * i * pow(i-1);
            n = n - count;
        }
        // 计算剩余的数
        int a = (n-1) / zone;
        int b = (n-1) % zone;
        int c = pow(zone-1) + a;
        int[] arr = new int[zone];
        int index = 0;
        int i = zone;
        while (i > 0){
            int d = pow(i-1);
            arr[index++] = c / d;
            c = c % d;
            i--;
        }
        return arr[b];
    }

    /**
     * 找到所属几位数区间
     * @param n
     * @return
     */
    private int findZone(int n){
        int i=1;
        long m = n;
        while (true){
            long count = 9L * i * pow(i-1);
            m = m-count;
            if(m > 0){
                i++;
            }else {
                break;
            }
        }
        return i;
    }

    private int pow(int n){
        int res=1;
        for(int i=0; i<n; i++){
            res *= 10;
        }
        return res;
    }

    public static void main(String[] args) {
        Leetcode400 leetcode400 = new Leetcode400();
        System.out.println(leetcode400.findNthDigit(11));
    }
}
