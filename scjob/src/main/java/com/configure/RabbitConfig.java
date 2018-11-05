package com.configure;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author szh
 * @create 2018-08-03 0:21
 **/
@Configuration
public class RabbitConfig {

//    @Bean
//    public Queue LagouQueue(){
//        return new Queue("Lagou");
//    }
//    //创建exchange，命名为log
//    @Bean
//    TopicExchange exchange() {
//        return new TopicExchange("Lagou");
//    }
//    //绑定log.error队列到exchange，routingkey为log.error
//    @Bean
//    Binding bindingExchangeError(Queue Hello, TopicExchange exchange) {
//        return BindingBuilder.bind(Hello).to(exchange).with("Lagou.#");
//    }
    private String laGouQueue = "Test2Queue";

    private String laGouExchange = "Test2Exchange";

    private String laGouFailQueue = "Test2FailQueue";
    private String laGouFailExchange = "Test2FailExchange";
    private String laGouFailExchangeRoutingKey = "TestFail2ExchangeRoutingKey";


    public static final String DEAD_LETTER_EXCHANGE = "x-dead-letter-exchange";

    public static final String DEAD_LETTER_ROUTING_KEY = "x-dead-letter-routing-key";

    @Bean
    public Queue laGouQueue() {
        Map<String, Object> map = new HashMap<>();
        map.put(DEAD_LETTER_EXCHANGE, laGouFailExchange);//设置死信交换机
        map.put(DEAD_LETTER_ROUTING_KEY, laGouFailExchangeRoutingKey);//设置死信routingKey
        return new Queue(laGouQueue, true, false, false, map);
    }
    @Bean
    public Queue laGouFailQueue() {
        return new Queue(laGouFailQueue);
    }
    @Bean
    public DirectExchange laGouFailExchange() {
        return new DirectExchange(laGouFailExchange);
    }


//    @Bean
//    public FanoutExchange fanoutExchange() {
//        return new FanoutExchange(laGouExchange, false, false);
//    }
//    @Bean
//    public Binding laGoubinding(Queue laGouFailQueue,
//                                DirectExchange laGouFailExchange) {
//        return BindingBuilder.bind(laGouFailQueue).to(laGouFailExchange);
//    }
    @Bean
    public SimpleMessageListenerContainer laGouListenerContainer(
            ConnectionFactory connectionFactory,
            LagouRabbitMqListener lagouRabbitMqListener,
            Queue laGouQueue) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setMessageListener(lagouRabbitMqListener);
        container.setQueues(laGouQueue);
        container.setConnectionFactory(connectionFactory);
        container.setConcurrentConsumers(10);
        container.setMaxConcurrentConsumers(20);
        container.setAcknowledgeMode(AcknowledgeMode.MANUAL);
        return container;
    }
}
