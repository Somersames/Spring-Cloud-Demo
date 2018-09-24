package com.somersames.config;

import com.somersames.proxy.impl.KuaiDaili;
import com.somersames.proxy.impl.WuYouDaili;
import com.somersames.proxy.impl.XiCIProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author szh
 * @create 2018-09-17 23:55
 * 主要用于项目一旦启动就初始化数据
 **/
//@Component
public class InitService {

    @Autowired
    KuaiDaili kuaiDaili;

    @Autowired
    XiCIProxy xiCIProxy;

    @Autowired
    WuYouDaili wuYouDaili;

    //启动代理程序
    @PostConstruct
    public void init(){

    }
}
