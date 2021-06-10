package com.uxtc.user.cloud.service.impl;

import com.uxtc.common.cloud.entity.UserDto;
import com.uxtc.user.cloud.entity.UmsMember;
import com.uxtc.user.cloud.entity.UmsMemberStatisticsInfo;
import com.uxtc.user.cloud.service.UserAdminService;
import com.uxtc.user.cloud.mapper.UserAdminDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author 鱼仔
 * @date 2021/4/21 2:21 下午
 * 概要
 */
@Service
@Slf4j
public class UserAdminServiceImpl implements UserAdminService {

    @Autowired
    private UserAdminDao userAdminDao;

    @Override
    public int addUmsMember() {
        UmsMemberStatisticsInfo umsMemberStatisticsInfo = new UmsMemberStatisticsInfo();
        umsMemberStatisticsInfo.setMemberId((long) Math.random());
        umsMemberStatisticsInfo.setAttendCount(100);
        umsMemberStatisticsInfo.setRecentOrderTime(new Date());
        return userAdminDao.addUmsMember(umsMemberStatisticsInfo);
    }
}
