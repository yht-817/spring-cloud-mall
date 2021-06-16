package com.uxtc.cloud.controller;

import com.uxtc.cloud.service.UserAdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author 鱼仔
 * @date 2021/4/21 2:19 下午
 * 概要
 */
@Controller
@Api(tags = "UserAdminController")
@RequestMapping("/user")
@Slf4j
public class UserAdminController {

    @Resource
    UserAdminService userAdminService;

    @ApiOperation("插入会员统计信息列表")
    @RequestMapping(value = "/addUmsMember", method = RequestMethod.GET)
    @ResponseBody
    public String addUmsMember() {
        String add = userAdminService.addUmsMember();
        return add;
    }
}
