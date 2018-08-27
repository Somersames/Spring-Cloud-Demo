package com.somersames.redisConfigure;

import com.netflix.discovery.converters.Auto;
import com.somersames.dto.ProxyDto;
import com.somersames.util.serialize.RedisObjectSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @author szh
 * @create 2018-08-26 23:46
 **/
@Configuration
public class RedisConfig {

    @Bean
    @ConfigurationProperties(prefix="spring.redis")
    JedisConnectionFactory jedisConnectionFactory() {
        JedisConnectionFactory jedisConnectionFactory =new JedisConnectionFactory();
        jedisConnectionFactory.setHostName("localhost"); // TODO 换成自己的ip
        jedisConnectionFactory.setPort(6379);
        jedisConnectionFactory.setPassword("somersames");
        return jedisConnectionFactory;
    }

    @Bean
    public RedisTemplate<String, ProxyDto> redisTemplate() {
        RedisTemplate<String, ProxyDto> template = new RedisTemplate<String, ProxyDto>();
        template.setConnectionFactory(jedisConnectionFactory());
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(new RedisObjectSerializer());
        return template;
    }


}
