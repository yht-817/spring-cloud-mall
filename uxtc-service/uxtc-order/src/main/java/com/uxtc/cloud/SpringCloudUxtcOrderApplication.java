package com.uxtc.cloud;

import io.seata.spring.annotation.datasource.EnableAutoDataSourceProxy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author 鱼仔
 * @date 2021/4/20 10:38 上午
 * 概要
 */
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
@EnableAutoDataSourceProxy
public class SpringCloudUxtcOrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudUxtcOrderApplication.class, args);
    }
}
