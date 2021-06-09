package com.uxtc.order.cloud.mapper;

import com.uxtc.order.cloud.entity.OrderInfo;
import org.mapstruct.Mapper;

/**
 * @author 鱼仔
 * @date 2021/6/7 3:59 下午
 * 概要
 */
@Mapper
public interface OrderDao {

    int insert(OrderInfo orderInfo);
}
