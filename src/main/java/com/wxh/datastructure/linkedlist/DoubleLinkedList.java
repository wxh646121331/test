package com.wxh.datastructure.linkedlist;

import com.wxh.datastructure.entity.Hero;

/**
 * @description:
 * @author: wuxinhong
 * @date: 2020/1/8
 * @time: 下午6:58
 */
public class DoubleLinkedList {
    /**
     * 初始化一个头节点，头节点不要动，不存入具体的数据
     */
    private DoubleNode<Hero> head = new DoubleNode<>(new Hero(0, "", ""));

    /**
     * 在链表尾部新增节点
     * @param node
     */
    public void add(DoubleNode<Hero> node){
        DoubleNode<Hero> temp = head;
        while (true){
            if(null == temp.next){
                temp.next = node;
                node.pre = temp;
                break;
            }
            temp = temp.next;
        }
    }

    /**
     * 打印链表
     */
    public void list(){
        if(null == head.next){
            System.out.println("链表为空");
        }
        DoubleNode<Hero> temp = head.next;
        while (true){
            if(null == temp){
                break;
            }
            System.out.println(temp.data);
            temp = temp.next;
        }
    }


    public static class DoubleNode<T>{
        T data;
        DoubleNode<T> pre;
        DoubleNode<T> next;

        public DoubleNode (T data){
            this.data = data;
        }
    }
}
