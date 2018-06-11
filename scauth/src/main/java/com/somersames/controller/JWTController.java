package com.somersames.controller;

import com.netflix.discovery.converters.Auto;
import com.somersames.util.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

/**
 * JWT相关的
 *
 * @author szh
 * @create 2018-05-30 16:49
 **/
@RestController
@RequestMapping("")
public class JWTController {

    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @RequestMapping("login")
    @ResponseBody
    public ResponseResult login(){
        ResponseResult responseResult =new ResponseResult();
        //TODO  首先是登录，登录之后生成一个JWT token
        stringRedisTemplate.opsForValue().set("aaa", "111");
        if("111".equals(stringRedisTemplate.opsForValue().get("aaa"))){
            responseResult.setCode(3333);
        }
        return responseResult;
    }
}
