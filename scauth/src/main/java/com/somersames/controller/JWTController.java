package com.somersames.controller;

import com.somersames.util.ResponseResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * JWT相关的
 *
 * @author szh
 * @create 2018-05-30 16:49
 **/
@RestController
@RequestMapping("")
public class JWTController {
    @RequestMapping("login")
    public ResponseResult login(){
        ResponseResult responseResult =new ResponseResult();
        //TODO  首先是登录，登录之后生成一个JWT token
        return responseResult;
    }
}
