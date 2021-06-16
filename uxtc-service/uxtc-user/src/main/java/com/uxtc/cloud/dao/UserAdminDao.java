package com.uxtc.cloud.dao;

import com.uxtc.cloud.entity.UmsMemberStatisticsInfo;
import com.uxtc.cloud.entity.OauthClientDetails;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author 鱼仔
 * @date 2021/4/21 2:20 下午
 * 概要
 */
@Mapper
public interface UserAdminDao {
    int addUmsMember(UmsMemberStatisticsInfo umsMemberStatisticsInfo);

    List<OauthClientDetails> queryClientList();
}
