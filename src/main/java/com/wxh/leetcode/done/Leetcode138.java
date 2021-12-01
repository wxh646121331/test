package com.wxh.leetcode.done;

import lombok.NoArgsConstructor;

/**
 * @author wuxinhong
 * @date 2021/7/22 10:38 上午
 */
public class Leetcode138 {

    public Node copyRandomList(Node head) {
        if(head == null){
            return null;
        }
        // 复制不带随机指针的链表
        Node newHead = new Node(head.val);
        Node p1 = head;
        Node p2 = newHead;
        while (null != p1.next){
            p1 = p1.next;
            Node temp = new Node(p1.val);
            p2.next = temp;
            p2 = p2.next;
        }
        // 复制随机指针
        p1 = head;
        p2 = newHead;
        while (null != p1){
            if(null != p1.random){
                Node temp1 = head;
                Node temp2 = newHead;
                while (temp1 != p1.random){
                    temp1 = temp1.next;
                    temp2 = temp2.next;
                }
                p2.random = temp2;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        return newHead;
    }

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
