package com.wxh.juc.ordering;

import org.openjdk.jol.info.ClassLayout;
import sun.lwawt.macosx.CSystemTray;

import java.io.IOException;

/**
 * @author wuxinhong
 * @date 2021/8/23 11:09 下午
 */
public class ThisEscape {
    private int num = 8;

    public ThisEscape(){
//        new Thread(() -> System.out.println(this.num)).start();
    }

    public static void main(String[] args) throws IOException {
        ThisEscape escape = new ThisEscape();
//        System.in.read();
        ClassLayout layout = ClassLayout.parseInstance(escape);
        System.out.println(layout.toPrintable());
    }
}
