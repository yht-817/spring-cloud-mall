package com.uxtc.order.cloud.entity;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author 鱼仔
 * @date 2021/6/7 3:49 下午
 * 概要
 */
@Data
public class UmsMemberStatisticsInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Long id;

    /**
     * member_id
     */
    private Long memberId;

    /**
     * 累计消费金额
     */
    private BigDecimal consumeAmount;

    /**
     * 订单数量
     */
    private Integer orderCount;

    /**
     * 优惠券数量
     */
    private Integer couponCount;

    /**
     * 评价数
     */
    private Integer commentCount;

    /**
     * 退货数量
     */
    private Integer returnOrderCount;

    /**
     * 登录次数
     */
    private Integer loginCount;

    /**
     * 关注数量
     */
    private Integer attendCount;

    /**
     * 粉丝数量
     */
    private Integer fansCount;

    /**
     * collect_product_count
     */
    private Integer collectProductCount;

    /**
     * collect_subject_count
     */
    private Integer collectSubjectCount;

    /**
     * collect_topic_count
     */
    private Integer collectTopicCount;

    /**
     * collect_comment_count
     */
    private Integer collectCommentCount;

    /**
     * invite_friend_count
     */
    private Integer inviteFriendCount;

    /**
     * 最后一次下订单时间
     */
    private Date recentOrderTime;

    public UmsMemberStatisticsInfo() {
    }
}
