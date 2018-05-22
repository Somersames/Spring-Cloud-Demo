package com.somersames;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Eureka的启动类
 *
 * @author szh
 * @create 2018-05-22 10:36
 **/
@SpringBootApplication
@EnableEurekaServer
public class EurekaConfigApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaConfigApplication.class);
    }
}
