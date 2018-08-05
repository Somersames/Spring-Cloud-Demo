package com.controller;

import com.mq.Sender;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author szh
 * @create 2018-08-04 0:07
 **/
@RestController
public class RabbitmqTest {

    @Resource
    Sender sender;

    @RequestMapping(value = "/rabbitmq/test",method = RequestMethod.POST)
    public String getRabbitmq(@RequestBody String body){
        sender.send();
        return "OK";
    }
}
