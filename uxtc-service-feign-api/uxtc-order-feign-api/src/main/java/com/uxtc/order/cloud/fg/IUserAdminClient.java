package com.uxtc.order.cloud.fg;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author 鱼仔
 * @date 2021/4/20 5:21 下午
 * 概要
 */
@FeignClient(value = "uxtc-user", fallback = IUserAdminFallback.class)
public interface IUserAdminClient {
    @GetMapping("/user/addUmsMember")
    String addUmsMember();
}
