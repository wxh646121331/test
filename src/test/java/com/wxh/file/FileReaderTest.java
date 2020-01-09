package com.wxh.file;

import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @description:
 * @author: wuxinhong
 * @date: 2019/12/3
 * @time: 下午6:58
 */
public class FileReaderTest {
    @Test
    public void test1(){
        File file = new File("test.txt");
        FileReader fr = null;
        try {
            fr = new FileReader(file);
            char[] c = new char[5];
            int len;
            while((len = fr.read(c)) != -1){
                System.out.print(new String(c, 0 , len));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
               if(null != fr){
                   fr.close();
               }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
