package com.wxh.datastructure.stack;

/**
 * @description:
 * @author: wuxinhong
 * @date: 2020/1/9
 * @time: 上午9:46
 */
public class ArrayStack {
    int [] arr;
    int size = 0;


    public ArrayStack(int n){
        arr = new int[n];
    }

    /**
     * 入栈
     * @param num
     */
    public void push(int num){
        if(size == arr.length){
            System.out.println("栈已满，不能压入");
            return;
        }
        arr[size++] = num;
    }

    /**
     * 出栈
     * @return
     */
    public int pop(){
        if(0 == size){
            throw new RuntimeException("栈为空，不能出栈");
        }
        return arr[--size];
    }

    public int peek(){
        if(0 == size){
            throw new RuntimeException("栈为空，不能出栈");
        }
        return arr[size-1];
    }

    public boolean isEmpty(){
        return 0 == size;
    }

}
