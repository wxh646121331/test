package com.wxh.leetcode;

/**
 * @author wuxinhong
 * @date 2021/7/27 11:08 下午
 */
public class Leetcode876 {

    public ListNode middleNode(ListNode head) {
        if(null == head){
            return head;
        }
        int len = 0;
        ListNode p = head;
        while (p != null){
            p = p.next;
            len ++;
        }
        p = head;
        int i=0;
        while (i < (len+1)/2){
            p = p.next;
            i++;
        }
        return p;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len = 0;
        ListNode p = head;
        while (p != null){
            p = p.next;
            len ++;
        }
        int m = len - n;
        if(m == 0){
            ListNode newNode = head.next;
            head.next = null;
            return newNode;
        }
        int i=0;
        p = head;
        while (i < m-1){
            p = p.next;
            i++;
        }
        p.next = p.next.next;
        p.next.next = null;
        return head;
    }

  public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

}
