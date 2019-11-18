package com.wxh.design.observer.schema2;

/**
 * @description:
 * @author: wuxinhong
 * @date: 2019/11/17
 * @time: 下午8:17s
 */
public interface Subject {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}
