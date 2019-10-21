package com.wxh.controller;

import com.wxh.bean.Person;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloWorldController {

    @RequestMapping("/hello")
    public String hello(){
        Person person;
        return "Hello, world!";
    }
}
