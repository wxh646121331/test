package com.wxh.datastructure.stack;

/**
 * @description:
 * @author: wuxinhong
 * @date: 2020/1/9
 * @time: 上午10:03
 */
public class LinkedStack {
    Node head;

    /**
     * 入栈
     * @param num
     */
    public void push(int num){
        if(null == head){
            head = new Node(num);
            return;
        }
        Node temp = head;
        while (true){
            if(null == temp.next){
                temp.next = new Node(num);
                break;
            }
            temp = temp.next;
        }
    }

    /**
     * 出栈
     * @return
     */
    public int pop(){
        if(null == head){
            throw new RuntimeException("栈为空，不能弹出");
        }
        if(null == head.next){
            int num = head.num;
            head = null;
            return num;
        }
        Node temp = head;
        // 遍历到倒数第二个元素
        while (true){
            if(null == temp.next.next){
                int num = temp.next.num;
                temp.next = null;
                return num;
            }
            temp = temp.next;
        }
    }

    public static class Node{
        int num;
        Node next;

        Node(int num){
            this.num = num;
        }

    }
}
