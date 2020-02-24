package com.wxh.vrp.ts;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @description:
 * @author: wuxinhong
 * @date: 2020/1/19
 * @time: 下午3:09
 */
@Getter
@Setter
public class Route implements Cloneable{
    /**
     * 车辆装载
     */
    private double load;

    /**
     * 违反各节点时间窗约束时长总和
     */
    private double subTime;

    /**
     * 路径总长度
     */
    double distance;

    /**
     * 客户节点列表
     */
    List<Customer> customerList;
}
