package com.uxtc.userfg.cloud.user;

import com.uxtc.common.cloud.entity.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author 鱼仔
 * @date 2021/4/20 5:21 下午
 * 概要
 */
@FeignClient(name = "uxtc-user", fallback = IUserAdminFallback.class)
public interface IUserAdminClient {
    @GetMapping("/user/loadByUsername")
    UserDto loadUserByUsername(@RequestParam Long userId);
}
