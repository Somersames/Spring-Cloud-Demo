package com.somersames;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 物品微服务的启动类
 *
 * @author szh
 * @create 2018-05-24 14:05
 **/
@SpringBootApplication
@EnableEurekaClient
public class GoodsConfigApplication {
    public static void main(String[] args) {
            SpringApplication.run(GoodsConfigApplication.class);
    }
}
