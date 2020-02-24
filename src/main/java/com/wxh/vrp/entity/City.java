package com.wxh.vrp.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @description:
 * @author: wuxinhong
 * @date: 2020/1/13
 * @time: 上午9:41
 */
@Getter
@Setter
@AllArgsConstructor
@ToString
public class City {
    private String cityName;
    private int x;
    private int y;
}

