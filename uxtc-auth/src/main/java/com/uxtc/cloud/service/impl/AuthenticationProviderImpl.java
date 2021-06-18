package com.uxtc.cloud.service.impl;

import com.uxtc.cloud.constant.MessageConstant;
import com.uxtc.cloud.domain.SecurityUser;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author 鱼仔
 * @date 2021/6/17 4:31 下午
 * 对用户登陆异常进行全局处理
 * 抛出自定义中文错误信息
 */
@Service
public class AuthenticationProviderImpl implements AuthenticationProvider {
    @Resource
    UserServiceImpl userDetailsService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();
        SecurityUser userDetails = (SecurityUser) userDetailsService.loadUserByUsername(username);
        /**
         * 对用户各个状态进行自定义
         */
        if (userDetails == null) {
            throw new BadCredentialsException(MessageConstant.USERNAME_PASSWORD_ERROR);
        }
        if (!new BCryptPasswordEncoder().matches(password, userDetails.getPassword())) {
            throw new BadCredentialsException(MessageConstant.USERNAME_PASSWORD_ERROR);
        }
        if (!userDetails.isEnabled()) {
            throw new BadCredentialsException(MessageConstant.ACCOUNT_LOCKED);
        }
        return new UsernamePasswordAuthenticationToken(userDetails, userDetails.getPassword(), userDetails.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return UsernamePasswordAuthenticationToken.class.equals(aClass);
    }
}
