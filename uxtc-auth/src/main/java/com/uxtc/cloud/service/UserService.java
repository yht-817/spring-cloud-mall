package com.uxtc.cloud.service;

import com.uxtc.cloud.common.entity.UserDto;

/**
 * @author 鱼仔
 * @date 2021/6/10 1:34 下午
 * 概要
 */
public interface UserService {
    /**
     * 查询用户详情
     *
     * @param userName
     * @return
     */
    UserDto loadUserByUsername(String userName);
}
