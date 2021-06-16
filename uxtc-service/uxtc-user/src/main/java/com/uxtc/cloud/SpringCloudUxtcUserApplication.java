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
 * @EnableAutoDataSourceProxy 分布式事务自动注入数据源
 * @EnableDiscoveryClient 把微服务注册到注册中心
 * @EnableFeignClients 对远程调度接口进行注入
 */
@EnableFeignClients(basePackages = "com.uxtc")
@EnableDiscoveryClient
@SpringBootApplication
@EnableAutoDataSourceProxy
public class SpringCloudUxtcUserApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudUxtcUserApplication.class, args);
    }
}
