package com.somersames.configure;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Raabbitmq的配置文件
 *
 * @author szh
 * @create 2018-08-19 15:18
 **/
@Configuration
public class RabbitmqConfig {

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
