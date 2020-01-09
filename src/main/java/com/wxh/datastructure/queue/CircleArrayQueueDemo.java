package com.wxh.datastructure.queue;

import java.util.Scanner;

/**
 * @description:
 * @author: wuxinhong
 * @date: 2020/1/5
 * @time: 下午9:34
 */
public class CircleArrayQueueDemo {
    public static void main(String[] args) {
        CircleArrayQueue queue = new CircleArrayQueue(3);
        // 接收用户输入
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop){
            System.out.println("s(show): 显示队列");
            System.out.println("e(exit): 退出程序");
            System.out.println("a(add): 添加数据到队列");
            System.out.println("g(get): 从队列取出数据");
            System.out.println("h(head): 查看队列头的数据");
            key = scanner.next().charAt(0);
            switch (key){
                case 's':
                    queue.show();
                    break;
                case 'a':
                    System.out.println("请输入一个数");
                    try{
                        int value = scanner.nextInt();
                        queue.add(value);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'g':
                    try{
                        int res = queue.get();
                        System.out.printf("取出的数据是%d\n", res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try{
                        int res = queue.head();
                        System.out.printf("队列头的数据是%d\n", res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出");
    }
}
