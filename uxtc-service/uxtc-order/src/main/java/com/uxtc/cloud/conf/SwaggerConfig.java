package com.uxtc.cloud.conf;

import com.uxtc.cloud.common.config.BaseSwaggerConfig;
import com.uxtc.cloud.common.entity.SwaggerProperties;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger API文档相关配置
 * Created by macro on 2018/4/26.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig extends BaseSwaggerConfig {

    @Override
    public SwaggerProperties swaggerProperties() {
        return SwaggerProperties.builder()
                .apiBasePackage("com.uxtc.cloud.controller")
                .title("uxtc订单系统")
                .description("uxtc订单系统相关接口文档")
                .contactName("uxtc")
                .version("1.0")
                .enableSecurity(true)
                .build();
    }
}
