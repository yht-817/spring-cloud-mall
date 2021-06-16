package com.uxtc.cloud.fg;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author 鱼仔
 * @date 2021/4/22 11:08 上午
 * Feign失败配置
 */
@Component
@Slf4j
public class IUserAdminFallback implements IUserAdminClient {
    @Override
    public String addUmsMember() {
        log.error("进入熔断程序");
        return "进行了熔断";
    }
}
