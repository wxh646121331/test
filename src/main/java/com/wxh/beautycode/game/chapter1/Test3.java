package com.wxh.beautycode.game.chapter1;

import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;

public class Test3 {
    public static void main(String[] args) {
        OperatingSystemMXBean mxBean = ManagementFactory.getOperatingSystemMXBean();
        while (true){
            System.out.println(mxBean.getAvailableProcessors());
        }
    }
}
