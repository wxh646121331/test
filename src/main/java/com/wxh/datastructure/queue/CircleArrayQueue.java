package com.wxh.datastructure.queue;

/**
 * @description:
 * 使用数组模拟环形队列的思路分析：
 * 1. front变量的含义做一个调整：front指向队列的第一个元素，也就是说arr[front]就是队列的第一个元素，front的初始值为0
 * 2. rear变量的含义做一个调整：rear指向队列的最后一个元素的后一个位置。因为希望空出一个空间作为约定
 * 3. 当队列满时，条件是：(rear + 1)%maxSize = front
 * 4. 队列为空的条件：rear == front
 * 5. 队列中有效的数据的个数：(rear + maxSize - front)%maxSize
 * @date: 2020/1/5
 * @time: 下午8:46
 */
public class CircleArrayQueue {
    /**
     * 数组的最大容量
     */
    private int maxSize;
    /**
     * 队列头，初始值0
     */
    private int front;
    /**
     * 队列尾，初始值0
     */
    private int rear;
    /**
     * 用于存放数据，模拟队列
     */
    private int[] arr;

    public CircleArrayQueue(int arrMaxSize){
        maxSize = arrMaxSize;
        arr = new int[maxSize];
    }

    public boolean isFull(){
        return (rear+1) % maxSize == front;
    }

    public boolean isEmpty(){
        return rear == front;
    }

    /**
     * 入队列
     * @param n
     */
    public void add(int n){
        if(isFull()){
            System.out.println("队列满，不加");
            return;
        }
        // 将数据加入队列
        arr[rear] = n;
        // 将 rear 后移，这里必须考虑取模
        rear = (rear + 1) % maxSize;
    }

    /**
     * 出队列
     * @return
     */
    public int get(){
        if(isEmpty()){
            throw new RuntimeException("队列空，不能取数据");
        }
        // 将 front 对应的值保存到临时变量
        int temp = arr[front];
        // 将front 后移，考虑取模
        front = (front + 1)%maxSize;
        // 将临时变量返回
        return temp;
    }

    public void show(){
        if(isEmpty()){
            System.out.println("队列空，没有数据");
            return;
        }
        for(int i = front; i<front+size(); i++){
            System.out.printf("arr[%d]=%d\n", i%maxSize, arr[i%maxSize]);
        }
    }

    /**
     * 队列中有效数据的个数
     * @return
     */
    public int size(){
        return (rear + maxSize - front)%maxSize;
    }

    /**
     * 显示队列头
     * @return
     */
    public int head(){
        if(isEmpty()){
            throw new RuntimeException("队列空，没有数据");
        }
        return arr[front];
    }


}
