package com.configure;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author szh
 * @create 2018-08-03 0:21
 **/
@Configuration
public class RabbitConfig {

    @Bean
    public Queue LagouQueue(){
        return new Queue("Lagou");
    }
    //创建exchange，命名为log
    @Bean
    TopicExchange exchange() {
        return new TopicExchange("Lagou");
    }
    //绑定log.error队列到exchange，routingkey为log.error
    @Bean
    Binding bindingExchangeError(Queue Hello, TopicExchange exchange) {
        return BindingBuilder.bind(Hello).to(exchange).with("Lagou.#");
    }
}
