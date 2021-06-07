package com.uxtc.userfg.cloud.user;

import com.uxtc.common.cloud.entity.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author 鱼仔
 * @date 2021/4/20 5:21 下午
 * 概要
 */
@FeignClient(value = "uxtc-user", fallback = IUserAdminFallback.class)
public interface IUserAdminClient {

    /**
     * 查询用户详情
     *
     * @param userId 用户ID
     * @return
     */
    @GetMapping("/user/loadUserByUsername")
    UserDto loadUserByUsername(@RequestParam Long userId);
}
