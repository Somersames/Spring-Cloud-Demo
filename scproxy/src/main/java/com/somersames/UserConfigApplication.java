package com.somersames;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author szh
 * @create 2018-05-23 14:33
 **/
@SpringBootApplication
//@EnableEurekaClient
public class UserConfigApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserConfigApplication.class);
    }
}
