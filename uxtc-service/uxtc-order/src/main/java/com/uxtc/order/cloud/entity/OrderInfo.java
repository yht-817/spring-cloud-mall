package com.uxtc.order.cloud.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 鱼仔
 * @description order_info
 * @date 2021/6/7 3:51 下午
 * 概要
 */
@Data
public class OrderInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Long id;

    /**
     * order_no
     */
    private String orderNo;

    /**
     * create_time
     */
    private Date createTime;

    public OrderInfo() {
    }
}