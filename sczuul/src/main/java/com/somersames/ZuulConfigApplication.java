package com.somersames;

import com.somersames.filter.PreRequestFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

/**
 * Zuul微服务的启动类
 *
 * @author szh
 * @create 2018-05-22 10:46
 **/
@SpringBootApplication
@EnableZuulProxy
public class ZuulConfigApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZuulConfigApplication.class);
    }
    @Bean
    public PreRequestFilter preRequestFilter(){
        return new PreRequestFilter();
    }
}
