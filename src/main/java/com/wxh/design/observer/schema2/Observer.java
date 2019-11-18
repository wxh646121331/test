package com.wxh.design.observer.schema2;

/**
 * @description:
 * @author: wuxinhong
 * @date: 2019/11/17
 * @time: 下午8:17
 */
public interface Observer {
    void update(float temperature, float pressure, float humidity);
}
