package com.uxtc.auth.cloud.service.impl;

import com.uxtc.auth.cloud.constant.MessageConstant;
import com.uxtc.auth.cloud.domain.SecurityUser;
import com.uxtc.common.cloud.constant.AuthConstant;
import com.uxtc.common.cloud.entity.UserDto;
import com.uxtc.userfg.cloud.user.IUserAdminClient;
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

import javax.servlet.http.HttpServletRequest;

/**
 * 用户管理业务类
 * Created by macro on 2020/6/19.
 */
@Component
@AllArgsConstructor
@Slf4j
public class UserServiceImpl implements UserDetailsService {

    private IUserAdminClient iUserAdminClient;

    @Autowired
    private HttpServletRequest request;

    /**
     * 获取用户数据基本数据和权限数据
     *
     * @param userId
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        String clientId = request.getParameter("client_id");
        UserDto userDto;
        // 判断用户系统
        if (AuthConstant.ADMIN_CLIENT_ID.equals(clientId)) {
            userDto = iUserAdminClient.loadUserByUsername(Long.valueOf(userId));
        } else {
            userDto = iUserAdminClient.loadUserByUsername(Long.valueOf(userId));
        }
        if (userDto == null) {
            throw new UsernameNotFoundException(MessageConstant.USERNAME_PASSWORD_ERROR);
        }
        userDto.setClientId(clientId);
        SecurityUser securityUser = new SecurityUser(userDto);
        if (!securityUser.isEnabled()) {
            throw new DisabledException(MessageConstant.ACCOUNT_DISABLED);
        } else if (!securityUser.isAccountNonLocked()) {
            throw new LockedException(MessageConstant.ACCOUNT_LOCKED);
        } else if (!securityUser.isAccountNonExpired()) {
            throw new AccountExpiredException(MessageConstant.ACCOUNT_EXPIRED);
        } else if (!securityUser.isCredentialsNonExpired()) {
            throw new CredentialsExpiredException(MessageConstant.CREDENTIALS_EXPIRED);
        }
        return securityUser;
    }
}
