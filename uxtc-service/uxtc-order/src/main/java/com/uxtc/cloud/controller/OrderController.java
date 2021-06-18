package com.uxtc.cloud.controller;

import com.uxtc.cloud.common.api.CommonResult;
import com.uxtc.cloud.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author 鱼仔
 * @date 2021/6/7 3:53 下午
 * 概要
 */

@Controller
@Api(tags = "OrderController 订单系统")
@RequestMapping("/order")
@Slf4j
public class OrderController {

    @Resource
    OrderService orderService;

    /**
     * 进行订单下单
     */

    @ApiOperation("进行订单下单")
    @ResponseBody
    @RequestMapping(value = "/insertOrder", method = RequestMethod.GET)
    public CommonResult<Object> insertOrder() {
        int add = orderService.insert();
        if (add > 0) {
            return CommonResult.success("");
        }
        return CommonResult.failed();
    }
}
