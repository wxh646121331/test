package com.wxh.file;

import org.junit.Test;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @description:
 * @author: wuxinhong
 * @date: 2019/12/3
 * @time: 下午7:06
 */
public class FileWriterTest {
    @Test
    public void test1(){
        FileWriter fw = null;
        try {
            fw = new FileWriter("writer.txt");
            fw.write("你好，世界\n你准备好的吗？\nHello, world");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(null != fw){
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
