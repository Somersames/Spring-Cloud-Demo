package com.mq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 接收者
 *
 * @author szh
 * @create 2018-08-03 0:20
 **/
@Component
@RabbitListener(queues = "Hello")
public class Receiver {
//    @RabbitHandler
//    public void process(String hello) {
//        System.out.println("接收到的数据为 : " + hello);
//    }
}
