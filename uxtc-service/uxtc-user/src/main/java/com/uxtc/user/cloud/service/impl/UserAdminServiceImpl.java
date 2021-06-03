package com.uxtc.user.cloud.service.impl;

import com.uxtc.common.cloud.entity.UserDto;
import com.uxtc.user.cloud.entity.UmsMember;
import com.uxtc.user.cloud.service.UserAdminService;
import com.uxtc.user.cloud.mapper.UserAdminDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 鱼仔
 * @date 2021/4/21 2:21 下午
 * 概要
 */
@Service
@Slf4j
public class UserAdminServiceImpl implements UserAdminService {

    @Autowired
    private UserAdminDao userAdminDao;

    @Override
    public UserDto loadUserByUsername(Long userId) {
        UserDto userDto = new UserDto();
        // 查询当前的用户信息和权限信息
        UmsMember umsMember = userAdminDao.getUserDetails(userId);
        userDto.setId(umsMember.getMemberLevelId());
        userDto.setUsername(umsMember.getUsername());
        userDto.setPassword(umsMember.getPassword());
        userDto.setStatus(umsMember.getStatus());
        return userDto;
    }
}
