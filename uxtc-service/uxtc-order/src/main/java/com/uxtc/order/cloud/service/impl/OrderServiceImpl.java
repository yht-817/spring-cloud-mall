package com.uxtc.order.cloud.service.impl;

import cn.hutool.core.util.IdUtil;
import com.uxtc.order.cloud.entity.OrderInfo;
import com.uxtc.order.cloud.mapper.OrderDao;
import com.uxtc.order.cloud.service.OrderService;
import com.uxtc.userfg.cloud.user.IUserAdminClient;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author 鱼仔
 * @date 2021/6/7 3:54 下午
 * 概要
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderDao orderDao;

    @Autowired
    IUserAdminClient iUserAdminClient;

    @Override
    @GlobalTransactional
    public int insert() {
        iUserAdminClient.addUmsMember();
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setOrderNo(IdUtil.randomUUID());
        orderInfo.setCreateTime(new Date());
        int add = orderDao.insert(orderInfo);
        int a = 100 / 0;
        return add;
    }
}
