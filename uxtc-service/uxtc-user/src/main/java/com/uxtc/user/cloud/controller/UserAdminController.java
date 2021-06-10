package com.uxtc.user.cloud.controller;

import com.uxtc.common.cloud.entity.UserDto;
import com.uxtc.user.cloud.service.UserAdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @ApiOperation("插入会员统计信息列表")
    @RequestMapping(value = "/addUmsMember", method = RequestMethod.GET)
    @ResponseBody
    public int addUmsMember() {
        int add = userAdminService.addUmsMember();
        return add;
    }
}
