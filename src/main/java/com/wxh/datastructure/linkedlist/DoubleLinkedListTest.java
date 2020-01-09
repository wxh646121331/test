package com.wxh.datastructure.linkedlist;

import com.wxh.datastructure.entity.Hero;
import com.wxh.datastructure.linkedlist.DoubleLinkedList.DoubleNode;
import org.junit.Test;

/**
 * @description:
 * @author: wuxinhong
 * @date: 2020/1/8
 * @time: 下午7:08
 */
public class DoubleLinkedListTest {
    @Test
    public void addTest(){
        DoubleNode<Hero> node1 = new DoubleNode<>(new Hero(1, "宋江", "及时雨"));
        DoubleNode<Hero> node2 = new DoubleNode<>(new Hero(2, "卢俊义", "玉麒麟"));
        DoubleNode<Hero> node3 = new DoubleNode<>(new Hero(3, "吴用", "智多星"));
        DoubleNode<Hero> node4 = new DoubleNode<>(new Hero(4, "林冲", "豹子头"));
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.add(node1);
        doubleLinkedList.add(node2);
        doubleLinkedList.add(node3);
        doubleLinkedList.add(node4);
        doubleLinkedList.list();
    }

}
