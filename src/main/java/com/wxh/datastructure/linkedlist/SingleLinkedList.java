package com.wxh.datastructure.linkedlist;

import java.util.Stack;

/**
 * 单链表
 */
class SingleLinkedList{
    /**
     * 初始化一个头节点，头节点不要动，不存入具体的数据
     */
    private HeroNode head = new HeroNode(0, "", "");

    /**
     * 当不考虑编号顺序时：
     * 1. 找到当前链表的最后节点
     * 2. 将最后这个节点的next指向新的节点
     * @param node
     */
    public void add(HeroNode node){
        // 因为head不能动，因此我们需要一个辅助遍历 temp
        HeroNode temp = head;
        while (true){
            if(temp.next == null){
                break;
            }
            temp = temp.next;
        }
        // 当退出while循环时，temp就指向了链表的最后
        temp.next = node;
    }

    /**
     * 需要按照编号的顺序添加
     * 1. 首先找到新添加的节点的位置，是通过辅助变量遍历链表
     * 2. 新的节点.next = temp.next
     * 3. temp.next = 新的节点
     */
    public void addByOrder(HeroNode node){
        HeroNode temp = head;
        // 因为单链表，我们找的temp是位于添加位置的前一个节点
        HeroNode next = temp.next;
        // flag标志添加的编号是否存在，默认是false
        boolean flag = false;
        while (true) {
            // 说明temp已经在链表的最后
            if (temp.next == null) {
                break;
            }
            // 位置找到
            if (temp.next.no > node.no) {
                break;
            } else if (temp.next.no == node.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        // 判断flag的值
        if(flag){
            System.out.printf("准备插入的英雄的编号%d已经存在，不能加入\n", node.no);
        }else {
            node.next = temp.next;
            temp.next = node;
        }
    }


    public void list(){
        if(head.next == null){
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head.next;
        while (true){
            if(temp == null){
                break;
            }
            // 输出节点的信息
            System.out.println(temp);
            temp = temp.next;
        }
    }

    /**
     * 按no修改节点信息
     * @param newHeroNode
     */
    public void update(HeroNode newHeroNode){
        if(null == head.next){
            System.out.println("链表为空，不能修改");
            return;
        }
        HeroNode temp = head.next;
        boolean flag = false;
        while (true){
            if(temp == null){
                break;
            }
            if(temp.no == newHeroNode.no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if(flag){
            temp.name = newHeroNode.name;
            temp.nickName = newHeroNode.nickName;
        }else {
            System.out.printf("链表中不存在编号%d的节点，不能修改", newHeroNode.no);
        }
    }

    /**
     * 删除节点思路：
     * 1. 先找到需要删除节点的前一个节点temp
     * 2. temp.next = temp.next.next
     * 3. 被删除的节点，将不会有其它引用指向，会被垃圾回收机制回收
     * @param no
     */
    public void del(int no){
        if(null == head.next){
            System.out.println("链表为空，不能删除");
            return;
        }
        HeroNode temp = head;
        boolean flag = false;
        while (true){
            if(null == temp.next){
                break;
            }
            if(temp.next.no == no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if(flag){
            temp.next = temp.next.next;
        }else{
            System.out.printf("编号为%d的节点不存在，不能删除", no);
        }
    }

    /**
     * 1. 求单链表中节点的个数
     * @param head
     * @return
     */
    public static int getLength(HeroNode head){
        if (null == head.next) {
            return 0;
        }
        HeroNode temp = head.next;
        int length = 0;
        while (null != temp){
            length ++;
            temp = temp.next;
        }
        return length;
    }

    /**
     * 2. 查找单链表的倒数第k个节点
     * 思路分析：
     * （1）遍历单链表，得到单链表中节点的个数 size
     * （2）得到 size 之后，遍历得到第(size - index)个节点，即为倒数第index个节点
     * @param head
     * @param index
     * @return
     */
    public static HeroNode getLastIndexNode(HeroNode head, int index){
        if(null == head.next){
            return null;
        }
        int size = SingleLinkedList.getLength(head);
        if(index <=0 || index>size){
            return null;
        }
        HeroNode cur = head.next;
        for(int i=0; i<size-index; i++){
            cur = cur.next;
        }
        return cur;
    }

    /**
     * 3. 单链表的反转
     * 思路分析：
     * （1）创建一个新的头节点 reverseHead = new HeroNode();
     * （2）从原单链表中取出节点
     * （3）将取出的节点插入reverseHead的后面
     * @param head
     * @return
     */
    public static void reverse(HeroNode head){
        if(null == head.next || null == head.next.next){
            return;
        }
        if(null == head.next.next){
            return;
        }
        HeroNode reverseHead = new HeroNode(0, "", "");
        HeroNode cur = head.next;
        while (null != cur){
            head.next = cur.next;
            cur.next = reverseHead.next;
            reverseHead.next = cur;
            cur = head.next;
        }
        head.next = reverseHead.next;
    }

    /**
     * 4. 从尾到头打印单链表（1：反向遍历(不推荐） 2：stack 栈）
     * 思路分析：
     * （1）先将单链表进行反转操作，然后再遍历，但是这样会破坏原来的单链表的结构
     * （2）将各个节点压入栈中，利用栈先进后出的特点，实现逆序打印
     * @param head
     */
    public static void reversePrint(HeroNode head){
        if(null == head.next){
            System.out.println("链表为空");
        }
        if(null == head.next.next){
            System.out.println(head.next);
            return;
        }
        Stack<HeroNode> stack = new Stack<HeroNode>();
        HeroNode cur = head.next;
        while (null != cur){
            stack.push(cur);
            cur = cur.next;
        }
        while (!stack.empty()){
            System.out.println(stack.pop());
        }
    }

    /**
     * 5. 合并两个有序的单链表，合并之后的链表依然有序
     * 思路分析：
     * （1）新建一个头节点 newHead = new HeroNode()
     * （2）比较 head1 和 head2 的编号大小，取出编号较小的节点，加入newHead的尾部
     * @param head1
     * @param head2
     * @return
     */
    public static void merge(HeroNode head1, HeroNode head2){
        if(null == head1.next){
            head1 = head2;
            return;
        }
        if(null == head2.next){
            return;
        }
        HeroNode newHead = new HeroNode(0, "", "");
        HeroNode cur1 = head1.next;
        HeroNode cur2 = head2.next;
        HeroNode cur = newHead;
        while (null!=cur1 && null!=cur2){
            if(cur1.no < cur2.no){
                cur.next = cur1;
                cur1 = cur1.next;
            }else {
                cur.next = cur2;
                cur2 = cur2.next;
            }
            cur = cur.next;
        }
        if(null != cur1){
            cur.next = cur1;
        }
        if(null != cur2){
            cur.next = cur2;
        }
        head1.next = newHead.next;
    }

    public HeroNode getHead() {
        return head;
    }
}
