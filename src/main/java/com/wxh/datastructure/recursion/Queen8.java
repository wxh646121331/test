package com.wxh.datastructure.recursion;

/**
 * @description: 八皇后问题
 * @author: wuxinhong
 * @date: 2020/1/16
 * @time: 上午9:32
 */
public class Queen8 {
    private int max = 8;
    private int[] res = new int[max];
    private int count = 0;
    /**
     * 先从第一行开始放皇后
     * @param args
     */
    public static void main(String[] args) {
        Queen8 queen8 = new Queen8();
        queen8.putQueen(0);
    }

    /**
     * 放第i个皇后
     * @param n
     * @return
     */
    public void putQueen(int n){
        if(n == max){
            print();
            return;
        }
        // 依次放入皇后，并判断是否冲突
        for(int i = 0; i<max; i++){
            // 先把当前这个皇后n，入到该行的第1列
            res[n] = i;
            // 不冲突，放入第n+1个皇后
            if(isOk(n)){
                putQueen(n+1);
            }
        }

    }

    private void print(){
        for(int i=0; i<8; i++){
            for(int j=0; j<8; j++){
                if(res[i] == j){
                    System.out.print("Q");
                }else {
                    System.out.print("*");
                }
                System.out.print(" ");
            }
            System.out.println();
        }
        System.out.println(++count);
    }

    /**
     * 校验第n个皇后放入的位置是否满足条件
     * @param n
     * @return
     */
    public boolean isOk(int n){
        for(int i=0; i<n ; i++){
            if(res[i]==res[n] || Math.abs(i-n) ==Math.abs(res[i]-res[n])){
                return false;
            }
        }
        return true;
    }

    public static long fun(long n){
        if(n <=0){
            throw new RuntimeException("输入有误！");
        }
        if(1 == n){
            return 1;
        }
        return n * fun(n-1);
    }
}
