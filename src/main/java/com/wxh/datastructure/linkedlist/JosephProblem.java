package com.wxh.datastructure.linkedlist;

/**
 * @description: 环形链表求解 Joseph 问题
 * @author: wuxinhong
 * @date: 2020/1/8
 * @time: 下午7:22
 */
public class JosephProblem {

    public static void main(String[] args) {
        Boy first = createCircleLinkedList(10);
        first.show();
        count(5, 3, 30);
    }

    /**
     * 求解问题
     * @param start 从start开始数数
     * @param k 数到k出列
     * @param n 一共n个人
     */
    public static void count(int start, int k, int n){
        if(start<1 || start>n || k<1 || n<1){
            System.out.println("参数不合法，请重新输入参数");
            return;
        }
        Boy first = createCircleLinkedList(n);
        Boy before = first;
        // 将first走到start位置，before 为first前一个节点
        if(1 == start){
            while (true){
                if(before.next == first){
                    break;
                }
                before = before.next;
            }
        }else {
            first = first.next;
            for(int i=2; i<start; i++){
                before = before.next;
                first = first.next;
            }
        }
        // 开始数数
        int c = 1;
        while (true){
            // 只剩下一个节点，直接打印退出
            if(first.next == first){
                System.out.println(first.no);
                return;
            }
            // 数到k，打印并从链表中删除，并重新从1开始报数
            if(c == k){
                System.out.println(first.no);
                before.next = first.next;
                first = first.next;
                c = 1;
            }else {
                c++;
                before = before.next;
                first = first.next;
            }
        }
    }

    /**
     * 按人数创建环形链表
     * @param n
     */
    public static Boy createCircleLinkedList(int n){
        if(n<=0){
            throw new RuntimeException("人数不能小于1");
        }
        Boy first = new Boy(1);
        first.next = first;
        Boy cur = first;
        for(int i=2; i<=n; i++){
            Boy boy = new Boy(i);
            boy.next = cur.next;
            cur.next = boy;
            cur = boy;
        }
        return first;
    }


    public static class Boy{
        int no;
        Boy next;

        public Boy(int no){
            this.no = no;
        }

        public void show(){
            Boy cur = this;
            while (true){
                System.out.println(cur.no);
                if(cur.next == this || null == cur.next){
                    break;
                }
                cur = cur.next;
            }
        }
    }
}


