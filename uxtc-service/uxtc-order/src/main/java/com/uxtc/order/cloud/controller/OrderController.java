package com.uxtc.order.cloud.controller;

import com.uxtc.common.cloud.api.CommonResult;
import com.uxtc.common.cloud.entity.UserDto;
import com.uxtc.order.cloud.entity.OrderInfo;
import com.uxtc.order.cloud.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @Autowired
    OrderService orderService;

    /**
     * 进行订单下单
     */
    @ApiOperation("进行订单下单")
    @RequestMapping(value = "/insertOrder", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<Object> insertOrder() {
        int add = orderService.insert();
        if (add > 0) {
            return CommonResult.success("");
        }
        return CommonResult.failed();
    }
}