package com.wxh.leetcode.done;

/**
 * @author wuxinhong
 * @date 2021/7/22 9:08 上午
 */
public class Leetcode52 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(null == headA || null == headB){
            return null;
        }
        ListNode pA = headA;
        int lenA = 1;
        ListNode pB = headB;
        int lenB = 1;
        // 分别遍历两个链表，得到链表长度
        while (null != pA.next){
            lenA ++;
            pA = pA.next;
        }
        while (null != pB.next){
            lenB++;
            pB = pB.next;
        }
        // 如果两个链表的最后一个节点不是同一个节点，说明没有相交，直接返回
        if(pA != pB){
            return null;
        }
        // 临时链表回到起点，然后将较长的链表遍历到剩余长度与较短链表一样的位置
        pA = headA;
        pB = headB;
        if(lenA > lenB){
            int temp = lenA - lenB;
            while (temp > 0){
                pA = pA.next;
                temp --;
            }
        }else {
            int temp = lenB - lenA;
            while (temp > 0){
                pB = pB.next;
                temp --;
            }
        }
        // 同时遍历两个链表，直到两个链表相遇或遍历完成
        while (true){
            if(pA == pB || null == pA){
                return pA;
            }
            pA = pA.next;
            pB = pB.next;
        }
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
