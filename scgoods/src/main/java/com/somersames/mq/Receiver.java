package com.somersames.mq;

import com.netflix.discovery.converters.Auto;
import com.somersames.util.ThreadReadTest;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * mq消息接收者
 *
 * @author szh
 * @create 2018-08-19 15:22
 **/
@Component
@RabbitListener(queues = "Hello")
public class Receiver {
    @Autowired
    ThreadReadTest threadReadTest;
    @RabbitHandler
    public void process(String hello) {
//        System.out.println("接收到的数据为 : " + hello);
        threadReadTest.readMessage(hello);
    }
}
