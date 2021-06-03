package com.uxtc.user.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author 鱼仔
 * @date 2021/4/20 10:38 上午
 * 概要
 */
@ComponentScan(basePackages = {"com.uxtc"})
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class SpringCloudUxtcUserApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudUxtcUserApplication.class, args);
    }
}
