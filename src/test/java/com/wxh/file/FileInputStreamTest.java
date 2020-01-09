package com.wxh.file;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @description:
 * @author: wuxinhong
 * @date: 2019/11/29
 * @time: 下午7:24
 */
public class FileInputStreamTest {
    @Test
    public void test1(){
        File file = new File("test.txt");
        FileInputStream fis = null;

        try{
            fis = new FileInputStream(file);
            int b;
            while((b = fis.read())!=-1){
                System.out.print((char)b);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(null != fis){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void test2(){
        File file = new File("test.txt");
        FileInputStream fis = null;

        try{
            fis = new FileInputStream(file);
            byte[] b = new byte[20];
            int len;
            while((len = fis.read(b))!=-1){
                System.out.print(new String(b, 0, len));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(null != fis){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
