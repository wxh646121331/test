package com.wxh.annotation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @description:
 * @author: wuxinhong
 * @date: 2020/2/16
 * @time: 下午6:24
 * Copyright (C) 2019 MTDP
 * All rights reserved
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Person {
    String name;
    Integer age;
}
