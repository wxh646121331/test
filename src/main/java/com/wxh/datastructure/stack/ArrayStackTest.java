package com.wxh.datastructure.stack;

import org.junit.Test;

/**
 * @description:
 * @author: wuxinhong
 * @date: 2020/1/9
 * @time: 上午9:51
 */
public class ArrayStackTest {
    @Test
    public void test(){
        ArrayStack stack = new ArrayStack(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
