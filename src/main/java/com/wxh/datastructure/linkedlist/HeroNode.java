package com.wxh.datastructure.linkedlist;

/**
 * @description:
 * @author: wuxinhong
 * @date: 2020/1/6
 * @time: 下午11:47
 */
public class HeroNode {
    public int no;
    public String name;
    public String nickName;
    public HeroNode next;

    public HeroNode(int hNo, String hName, String hNickName){
        no = hNo;
        name = hName;
        nickName = hNickName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
