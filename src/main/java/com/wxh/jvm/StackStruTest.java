package com.wxh.jvm;

import java.io.ObjectInputStream;

/**
 * javap -v StackStruTest.class
 */
public class StackStruTest {
    public static void main(String[] args) {
//        int i = 2 + 3;
        int i=2;
        int j=3;
        int k = i+j;
    }

    private void test1(){
        for(int i=0; i<10; i++){
            int j=i;
        }
    }
}
