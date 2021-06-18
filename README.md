# spring-cloud-mall

#### 介绍
spring-cloud-mall 是用 **spring cloud 与spring cloud alibaba** 集成的微服务框架，该框架实现了基础的架子开箱即用，里面集成了oauth2鉴权（oauth2的四种模式）、授权资源，分布式事务、分布式链路追踪、统一异常处理等功能，该微服务的注册中心使用了nacos


#### 架构图
![架构图](https://images.gitee.com/uploads/images/2021/0618/095042_bff94964_1393776.png "屏幕截图.png")

#### 代码结构

spring-cloud-mall
├── uxtc-auth    -- 授权服务提供
├── uxtc-common  -- 常用工具封装包
├── uxtc-gateway -- Spring Cloud 网关
├── uxtc-service 
├    ├── uxtc-user  -- 用户服务模块
├    ├── uxtc-order -- 订单服务模块
├    ├── uxtc-admin -- 后台管理模块
├── uxtc-service-feign-api    -- 业务模块api封装
├    ├── uxtc-order-feign-api -- 订单api 
└──  └── uxtc-order-feign-api -- 用户api 

