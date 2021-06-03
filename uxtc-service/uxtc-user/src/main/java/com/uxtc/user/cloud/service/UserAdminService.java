package com.uxtc.user.cloud.service;

import com.uxtc.common.cloud.entity.UserDto;
import feign.Param;

/**
 * @author 鱼仔
 * @date 2021/4/21 2:20 下午
 * 概要
 */
public interface UserAdminService {
    UserDto loadUserByUsername(Long userId);
}
