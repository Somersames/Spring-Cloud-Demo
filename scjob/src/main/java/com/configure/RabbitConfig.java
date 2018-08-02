package com.configure;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author szh
 * @create 2018-08-03 0:21
 **/
@Configuration
public class RabbitConfig {

    @Bean
    public Queue helloQueue(){
        return new Queue("Hello");
    }
}
