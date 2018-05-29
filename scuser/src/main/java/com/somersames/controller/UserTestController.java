package com.somersames.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试类的Controller
 *
 * @author szh
 * @create 2018-05-22 10:29
 **/
@RestController
@RequestMapping("testuser")
public class UserTestController {
    @GetMapping("/testzuul")
    public String testZUul(){
        return "测试Zuul";
    }
}
