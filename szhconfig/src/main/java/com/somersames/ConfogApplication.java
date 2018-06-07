package com.somersames;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 配置中心
 *
 * @author szh
 * @create 2018-06-08 0:19
 **/
@SpringBootApplication
@EnableConfigServer
@EnableAutoConfiguration
@EnableEurekaClient
public class ConfogApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConfogApplication.class);
    }
}
