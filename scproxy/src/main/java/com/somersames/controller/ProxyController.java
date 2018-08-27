package com.somersames.controller;

import com.netflix.discovery.converters.Auto;
import com.somersames.proxy.impl.WuYouDaili;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author szh
 * @create 2018-08-26 23:20
 **/
@RestController
public class ProxyController {


    @Autowired
    WuYouDaili wuYouDaili;

    @RequestMapping(value = "/grab",method = RequestMethod.GET)
    public  String test(){
        wuYouDaili.grad();
        return "A";
    }
    @RequestMapping(value = "/say",method = RequestMethod.GET)
    public  String test2(){
        return  wuYouDaili.say();
    }
}
