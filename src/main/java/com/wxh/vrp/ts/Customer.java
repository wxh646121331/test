package com.wxh.vrp.ts;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @description: 客户信息
 * @author: wuxinhong
 * @date: 2020/1/19
 * @time: 下午3:07
 */
@Getter
@Setter
@ToString
public class Customer {
    private int id;
    private int routeId;
    private double demand;
    private double x;
    private double y;
    private double begin;
    private double end;
    private double server;
}
