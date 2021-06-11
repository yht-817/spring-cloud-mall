package com.uxtc.user.cloud.service;

import com.uxtc.common.cloud.entity.UserDto;
import com.uxtc.user.cloud.entity.OauthClientDetails;
import com.uxtc.user.cloud.in.OauthClientDetailIn;
import feign.Param;

import java.util.List;

/**
 * @author 鱼仔
 * @date 2021/4/21 2:20 下午
 * 概要
 */
public interface UserAdminService {
    int addUmsMember();
}
