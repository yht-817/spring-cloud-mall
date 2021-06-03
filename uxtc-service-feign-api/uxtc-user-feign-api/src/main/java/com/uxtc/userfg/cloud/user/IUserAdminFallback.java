package com.uxtc.userfg.cloud.user;

import com.uxtc.common.cloud.entity.UserDto;

/**
 * @author 鱼仔
 * @date 2021/4/22 11:08 上午
 * Feign失败配置
 */
public class IUserAdminFallback implements IUserAdminClient {


    @Override
    public UserDto loadUserByUsername(Long userId) {
        return null;
    }
}
