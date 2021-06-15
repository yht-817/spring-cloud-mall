package com.uxtc.order.cloud.service.impl;

import cn.hutool.core.util.IdUtil;
import com.uxtc.order.cloud.entity.OrderInfo;
import com.uxtc.order.cloud.fg.IUserAdminClient;
import com.uxtc.order.cloud.mapper.OrderDao;
import com.uxtc.order.cloud.service.OrderService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author 鱼仔
 * @date 2021/6/7 3:54 下午
 * 概要
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Resource
    OrderDao orderDao;

    @Resource
    IUserAdminClient iUserAdminClient;

    @Override
    @GlobalTransactional
    public int insert() {
        String addUmsMember = iUserAdminClient.addUmsMember();
        log.error("熔断返回的参数:" + addUmsMember);
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setOrderNo(IdUtil.randomUUID());
        orderInfo.setCreateTime(new Date());
        int add = orderDao.insert(orderInfo);
        return add;
    }
}
