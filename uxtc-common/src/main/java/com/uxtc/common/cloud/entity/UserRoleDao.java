package com.uxtc.common.cloud.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 登录用户信息
 * Created by 鱼仔 on 2020/6/19.
 */
@Data
public class UserRoleDao {

    /**
     * ID
     */
    private Long id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 用户密码
     */
    private String password;
    /**
     * 用户状态
     */
    private Boolean enabled;
    /**
     * 登录客户端ID
     */
    private String clientId;
    /**
     * 权限数据
     */
    private List<String> authorities;

    public UserRoleDao() {

    }
}
