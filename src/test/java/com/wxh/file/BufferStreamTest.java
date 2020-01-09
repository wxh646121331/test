package com.wxh.file;

import org.junit.Test;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @description:
 * @author: wuxinhong
 * @date: 2019/12/3
 * @time: 下午7:09
 */
public class BufferStreamTest {
    @Test
    public void test1(){
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        try {
            fis = new FileInputStream("test.txt");
            bis = new BufferedInputStream(fis);
            byte[] b = new byte[15];
            int len;
            while ((len = bis.read(b)) != -1){
                System.out.print(new String(b, 0, len));
                System.out.println(len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
