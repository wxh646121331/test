package com.wxh.datastructure.entity;

import lombok.Getter;

/**
 * @description:
 * @author: wuxinhong
 * @date: 2020/1/8
 * @time: 下午6:59
 */
@Getter
public class Hero {
    private int no;
    private String name;
    private String nickName;

    public Hero(int no, String name, String nickName){
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "Hero{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
