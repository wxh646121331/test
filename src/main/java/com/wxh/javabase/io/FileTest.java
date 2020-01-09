package com.wxh.javabase.io;

import java.io.File;

/**
 * 凡是与输入、输出相关的类，接口都定义在java.io下
 */

public class FileTest {
    public void test1(){
        File file = new File("classpath:person.yml");
        System.out.println(file.canRead());
    }

}
