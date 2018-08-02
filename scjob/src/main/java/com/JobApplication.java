package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


/**
 * @author szh
 * @create 2018-08-03 0:24
 **/
@SpringBootApplication
//@EnableEurekaClient
public class JobApplication {
    public static void main(String[] args) {
        SpringApplication.run(JobApplication.class);
    }
}
