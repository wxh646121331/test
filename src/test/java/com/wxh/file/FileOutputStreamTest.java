package com.wxh.file;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @description:
 * @author: wuxinhong
 * @date: 2019/12/3
 * @time: 上午10:08
 */
public class FileOutputStreamTest {
    @Test
    public void test1(){
        FileOutputStream fos = null;
        FileInputStream fis = null;
        try {
            fos = new FileOutputStream("output1.txt");
            fos.write("你好，世界".getBytes());
            fis = new FileInputStream("output1.txt");
            byte[] b = new byte[3];
            int len;
            while((len = fis.read(b)) != -1){
                System.out.print(new String(b, 0 ,len));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(null != fos){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
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
        File file1 = new File("output1.txt");
        File file2 = new File("output2.txt");
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream(file1);
            fos = new FileOutputStream(file2);
            byte[] b = new byte[16];
            int len;
            while ((len = fis.read(b)) != -1){
                fos.write(b, 0 , len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(null != fos){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(null != fis){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
