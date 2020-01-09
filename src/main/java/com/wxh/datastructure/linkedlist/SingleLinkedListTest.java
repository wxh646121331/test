package com.wxh.datastructure.linkedlist;

import org.junit.Test;

/**
 * @description:
 * 链表总结：
 * 1. 链表是以节点的方式来存储，是链式存储
 * 2. 第个节点包含 data 域，next 域：指向下一个节点
 * 3. 链表的各个节点不一定是连续存储
 * 4. 链表分带头节点的链表和没有头节点的链表，根据实际需求来确定
 *
 * 单链表常见面试题：
 * 1. 求单链表中节点的个数
 * 2. 查找单链表的倒数第k个节点
 * 3. 单链表的反转
 * 4. 从尾到头打印单链表（1：反向遍历(不推荐） 2：stack 栈）
 * 5. 合并两个有序的单链表，合并之后的链表依然有序

 * @author: wuxinhong
 * @date: 2020/1/5
 * @time: 下午10:38
 */
public class SingleLinkedListTest {

    @Test
    public void addTest(){
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.add(hero1);
        singleLinkedList.add(hero3);
        singleLinkedList.add(hero2);
        singleLinkedList.add(hero4);
        singleLinkedList.list();

    }

    @Test
    public void addByOrderTest(){
        SingleLinkedList singleLinkedList = initSingleLinkedList();
        singleLinkedList.list();
    }

    @Test
    public void updateTest(){
        SingleLinkedList singleLinkedList = initSingleLinkedList();
        singleLinkedList.list();
        HeroNode newHeroNode = new HeroNode(2, "小卢", "玉麒麟~~");
        singleLinkedList.update(newHeroNode);
        System.out.println("修改后的链表");
        singleLinkedList.list();
    }

    @Test
    public void delTest(){
        SingleLinkedList singleLinkedList = initSingleLinkedList();
        singleLinkedList.list();
        singleLinkedList.del(1);
        singleLinkedList.del(4);
        System.out.println("删除后的链表");
        singleLinkedList.list();
    }

    @Test
    public void getLengthTest(){
        SingleLinkedList singleLinkedList = initSingleLinkedList();
        int len = SingleLinkedList.getLength(singleLinkedList.getHead());
        System.out.printf("单链表中节点的个数为：%d\n", len);
    }

    @Test
    public void getLastIndexNodeTest(){
        SingleLinkedList singleLinkedList = initSingleLinkedList();
        HeroNode node1 = SingleLinkedList.getLastIndexNode(singleLinkedList.getHead(), 1);
        System.out.printf("倒数第%d个节点为：%s\n", 1, node1);
        HeroNode node2 = SingleLinkedList.getLastIndexNode(singleLinkedList.getHead(), 2);
        System.out.printf("倒数第%d个节点为：%s\n", 2, node2);
        HeroNode node3 = SingleLinkedList.getLastIndexNode(singleLinkedList.getHead(), 3);
        System.out.printf("倒数第%d个节点为：%s\n", 3, node3);
        HeroNode node4 = SingleLinkedList.getLastIndexNode(singleLinkedList.getHead(), 4);
        System.out.printf("倒数第%d个节点为：%s\n", 4, node4);
        HeroNode node5 = SingleLinkedList.getLastIndexNode(singleLinkedList.getHead(), 5);
        System.out.printf("倒数第%d个节点为：%s\n", 5, node5);
    }

    /**
     *
     */
    @Test
    public void reverseTest(){
        SingleLinkedList singleLinkedList = initSingleLinkedList();
        singleLinkedList.list();
        SingleLinkedList.reverse(singleLinkedList.getHead());
        System.out.println("反转后的链表");
        singleLinkedList.list();
    }

    @Test
    public void reversePrintTest(){
        SingleLinkedList singleLinkedList = initSingleLinkedList();
        singleLinkedList.list();
        System.out.println("逆序打印结果：");
        SingleLinkedList.reversePrint(singleLinkedList.getHead());
    }

    @Test
    public void mergeTest(){
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        SingleLinkedList singleLinkedList1 = new SingleLinkedList();
        singleLinkedList1.addByOrder(hero3);
        singleLinkedList1.addByOrder(hero1);
        System.out.println("链表1：");
        singleLinkedList1.list();
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");
        SingleLinkedList singleLinkedList2 = new SingleLinkedList();
        singleLinkedList2.addByOrder(hero2);
        singleLinkedList2.addByOrder(hero4);
        System.out.println("链表2");
        singleLinkedList2.list();
        System.out.println("合并后的链表");
        SingleLinkedList.merge(singleLinkedList1.getHead(), singleLinkedList2.getHead());
        singleLinkedList1.list();
    }

    private SingleLinkedList initSingleLinkedList(){
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.addByOrder(hero1);
        singleLinkedList.addByOrder(hero3);
        singleLinkedList.addByOrder(hero2);
        singleLinkedList.addByOrder(hero4);
        return singleLinkedList;
    }
}
