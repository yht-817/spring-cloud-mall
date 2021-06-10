package com.uxtc.user.cloud.mapper;

import com.uxtc.user.cloud.entity.UmsMember;
import com.uxtc.user.cloud.entity.UmsMemberStatisticsInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author 鱼仔
 * @date 2021/4/21 2:20 下午
 * 概要
 */
@Mapper
public interface UserAdminDao {
    int addUmsMember(UmsMemberStatisticsInfo umsMemberStatisticsInfo);
}
