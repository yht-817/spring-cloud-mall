package com.uxtc.auth.cloud.mapper;

import com.uxtc.auth.cloud.entity.RoleResources;
import com.uxtc.common.cloud.entity.UserDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author 鱼仔
 * @date 2021/6/10 1:37 下午
 * 概要
 */
@Mapper
public interface UserServiceDao {

    UserDto loadUserByUsername(@Param("userName") String userName);

    List<String> getRoles(@Param("id") Long id);

    List<RoleResources> getRoleList();
}
