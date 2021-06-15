package com.uxtc.user.cloud.controller;

import com.uxtc.common.cloud.api.CommonResult;
import com.uxtc.user.cloud.entity.OauthClientDetails;
import com.uxtc.user.cloud.in.OauthClientDetailIn;
import com.uxtc.user.cloud.service.UserAdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

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
    public int addUmsMember() {
        int add = userAdminService.addUmsMember();
        return add;
    }
}
