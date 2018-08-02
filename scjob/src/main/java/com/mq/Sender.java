package com.mq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 测试Rabbitmq的
 *
 * @author szh
 * @create 2018-08-03 0:17
 **/
@Component
public class Sender {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(){
        String contet ="Hello" + new Date();
        this.amqpTemplate.convertAndSend(contet);
     }

}
