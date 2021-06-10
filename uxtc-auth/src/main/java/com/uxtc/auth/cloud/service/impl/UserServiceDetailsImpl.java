package com.uxtc.auth.cloud.service.impl;

import com.uxtc.auth.cloud.mapper.UserServiceDao;
import com.uxtc.auth.cloud.service.UserService;
import com.uxtc.common.cloud.entity.UserDto;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 鱼仔
 * @date 2021/6/10 1:35 下午
 * 概要
 */
@Service
public class UserServiceDetailsImpl implements UserService {

    @Resource
    private UserServiceDao userServiceDao;

    @Override
    public UserDto loadUserByUsername(String userName) {
        // 查询当前用户的详情
        UserDto userDto = userServiceDao.loadUserByUsername(userName);
        // 查询当前用户的权限
        List<String> roles = userServiceDao.getRoles(userDto.getId());
        userDto.setRoles(roles);
        return userDto;
    }
}
