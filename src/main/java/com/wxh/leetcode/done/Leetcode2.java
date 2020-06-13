package com.wxh.leetcode.done;

/**
 * @description:
 * @author: wuxinhong
 * @date: 2020/6/2
 * @time: 下午11:13
 * Copyright (C) 2020 MTDP
 * All rights reserved
 */
public class Leetcode2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(null == l1){
            return l2;
        }
        if(null == l2){
            return l1;
        }
        ListNode p1 = l1;
        ListNode p2 = l2;
        int value = p1.val + p2.val;
        int val = value % 10;
        int carry = value / 10;
        ListNode head = new ListNode(val);
        ListNode cur = head;
        p1 = p1.next;
        p2 = p2.next;
        while (true){
            if(null==p1 && null==p2){
                break;
            }
            if(p1==null){
                value = p2.val + carry;
                p2 = p2.next;
            }else if(p2==null){
                value = p1.val + carry;
                p1 = p1.next;
            }else {
                value = p1.val + p2.val + carry;
                p1 = p1.next;
                p2 = p2.next;
            }
            val = value % 10;
            carry = value / 10;
            ListNode newNode = new ListNode(val);
            cur.next = newNode;
            cur = cur.next;
        }
        if(carry > 0){
            ListNode newNode = new ListNode(carry);
            cur.next = newNode;
        }
        return head;
    }

    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
