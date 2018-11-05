package com.somersames.configure;

import lombok.Data;
import org.springframework.amqp.core.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * Raabbitmq的配置文件
 *
 * @author szh
 * @create 2018-08-19 15:18
 **/
@Configuration
@ConfigurationProperties(ignoreUnknownFields = false, prefix = "somersames.rabbitmq")
@Data
public class RabbitmqConfig {

    private String laGouFailQueue = "laGou2FailQueue";
    private String laGouQueue = "laGou2Queue";
    private String laGouFailExchange = "laGou2FailExchange";
    private String laGouFailExchangeRoutingKey = "laGou2FailExchangeRoutingKey";
    public static final String DEAD_LETTER_EXCHANGE = "x-dead-letter-exchange";

    public static final String DEAD_LETTER_ROUTING_KEY = "x-dead-letter-routing-key";
    @Bean
    public Queue laGouFailQueue() {
        return new Queue(laGouFailQueue);
    }
    @Bean
    public DirectExchange laGouFailExchange() {
        return new DirectExchange(laGouFailExchange);
    }
    @Bean
    public Binding bindingLagouFailExchange(Queue laGouFailQueue, DirectExchange laGouFailExchange) {
        return BindingBuilder.bind(laGouFailQueue).to(laGouFailExchange).with(laGouFailExchangeRoutingKey);
    }
    @Bean
    public Queue laGouQueue() {
        Map<String, Object> map = new HashMap<>();
        map.put(DEAD_LETTER_EXCHANGE, laGouFailExchange);//设置死信交换机
        map.put(DEAD_LETTER_ROUTING_KEY, laGouFailExchangeRoutingKey);//设置死信routingKey
        return new Queue(laGouQueue, true, false, false, map);
    }
}
