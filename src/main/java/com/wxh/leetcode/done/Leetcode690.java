package com.wxh.leetcode.done;

import lombok.Getter;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @description:
 * @author: wuxinhong
 * @date: 2020/6/1
 * @time: 下午11:08
 * Copyright (C) 2020 MTDP
 * All rights reserved
 */
public class Leetcode690 {
    public int getImportance(List<Employee> employees, int id) {

        Map<Integer, Employee> map = employees.stream().collect(Collectors.toMap(x -> x.id, Function.identity()));
        return getImportance(map, id);
    }

    public int getImportance(Map<Integer, Employee> map, int id){
        if(!map.containsKey(id)){
            return 0;
        }
        Employee employee = map.get(id);
        int res = employee.importance;
        if(null == employee.subordinates || employee.subordinates.isEmpty()){
            return res;
        }
        for(Integer next : employee.subordinates){
            res += getImportance(map, next);
        }
        return res;
    }

    public static class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    }
}
