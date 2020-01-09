package com.wxh.datastructure.queue;

/**
 * @description:
 * @author: wuxinhong
 * @date: 2020/1/5
 * @time: 下午7:15
 */
public class ArrayQueue {
    /**
     * 数组的最大容量
     */
    private int maxSize;
    /**
     * 队列头
     */
    private int front;
    /**
     * 队列尾
     */
    private int rear;
    /**
     * 用于存放数据，模拟队列
     */
    private int[] arr;

    public ArrayQueue(int arrMaxSize){
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        //指向队列头部，指向队列头的前一个位置
        front = -1;
        // 指向队列尾，指向队列尾的数据
        rear = -1;
    }

    public boolean isFull(){
        return rear == maxSize -1;
    }

    public boolean isEmpty(){
        return rear == front;
    }

    /**
     * 入队列
     * @param n
     */
    public void addQueue(int n){
        if(isFull()){
            System.out.println("队列已满，不能加入队列");
        }
        rear++;
        arr[rear] = n;
    }

    /**
     * 出队列
     * @return
     */
    public int getQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列为空，不能取数据");
        }
        front ++; // front后移
        return arr[front];
    }

    /**
     * 显示列表的所有数据
     */
    public void show(){
        if(isEmpty()){
            System.out.println("队列为空，没有数据");
            return;
        }
        for(int i=0; i < arr.length; i++){
            System.out.printf("arr[%d]=%d\n", i, arr[i]);
        }
    }

    public int headQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列为空，不能取数据");
        }
        return arr[front+1];
    }

}
