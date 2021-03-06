package com.uxtc.cloud.service.impl;

import com.uxtc.cloud.constant.MessageConstant;
import com.uxtc.cloud.domain.SecurityUser;
import com.uxtc.cloud.service.UserService;
import com.uxtc.cloud.common.entity.UserDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 用户管理业务类
 *
 * @author 鱼仔
 * @date 2020/6/19
 */
@Component
@AllArgsConstructor
@Slf4j
public class UserServiceImpl implements UserDetailsService {

    @Resource
    private HttpServletRequest request;

    @Resource
    UserService userService;

    /**
     * 获取用户数据基本数据和权限数据
     *
     * @param username 用户名
     * @return
     */
    @Override
    public UserDetails loadUserByUsername(String username) {
        String clientId = request.getParameter("client_id");
        log.error("获取的客户端id：" + clientId);
        UserDto userDto = userService.loadUserByUsername(username);
        if (userDto != null) {
            userDto.setClientId(clientId);
            SecurityUser securityUser = new SecurityUser(userDto);
            return securityUser;
        }
        return null;
    }
}
