package com.somersames;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

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
}
