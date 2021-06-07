package com.uxtc.user.cloud.controller;

import com.uxtc.common.cloud.api.CommonResult;
import com.uxtc.common.cloud.entity.UserDto;
import com.uxtc.user.cloud.service.UserAdminService;
import com.uxtc.userfg.cloud.user.IUserAdminClient;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Map;

/**
 * @author 鱼仔
 * @date 2021/4/21 2:19 下午
 * 概要
 */
@Controller
@Api(tags = "UserAdminController 用户体系")
@RequestMapping("/user")
@Slf4j
public class UserAdminController {

    @Autowired
    UserAdminService userAdminService;


    @ApiOperation("根据用户ID查询当前的用户详情")
    @RequestMapping(value = "/loadUserByUsername", method = RequestMethod.GET)
    @ResponseBody
    public UserDto loadUserByUsername(@RequestParam(value = "userId", defaultValue = "123456789012") Long userId) {
        log.error("获取的参数：{}", userId);
        UserDto userDto = userAdminService.loadUserByUsername(userId);
        log.error("查询数据开始:{}", userDto.toString());
        return userDto;
    }
}
