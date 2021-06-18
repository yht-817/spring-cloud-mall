package com.uxtc.cloud.service.impl;

import com.uxtc.cloud.constant.MessageConstant;
import com.uxtc.cloud.mapper.UserServiceDao;
import com.uxtc.cloud.service.UserService;
import com.uxtc.cloud.common.entity.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 鱼仔
 * @date 2021/6/10 1:35 下午
 * 概要
 */
@Service
@Slf4j
public class UserServiceDetailsImpl implements UserService {

    @Resource
    private UserServiceDao userServiceDao;

    @Override
    public UserDto loadUserByUsername(String userName) {
        // 查询当前用户的详情
        UserDto userDto = userServiceDao.loadUserByUsername(userName);
        if (userDto == null) {
            // 当没有查询到用户直接抛出异常
            throw new UsernameNotFoundException(MessageConstant.USERNAME_PASSWORD_ERROR);
        }
        // 查询当前用户角色权限
        List<String> roles = userServiceDao.getRoles(userDto.getId());
        userDto.setRoles(roles);
        return userDto;
    }
}
