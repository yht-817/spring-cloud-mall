package com.uxtc.cloud.service.impl;

import com.uxtc.cloud.service.UserAdminService;
import com.uxtc.cloud.entity.UmsMemberStatisticsInfo;
import com.uxtc.cloud.dao.UserAdminDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author 鱼仔
 * @date 2021/4/21 2:21 下午
 * 概要
 */
@Service
@Slf4j
public class UserAdminServiceImpl implements UserAdminService {

    @Resource
    private UserAdminDao userAdminDao;

    @Override
    @Transactional
    public String addUmsMember() {
        UmsMemberStatisticsInfo umsMemberStatisticsInfo = new UmsMemberStatisticsInfo();
        umsMemberStatisticsInfo.setMemberId((long) Math.random());
        umsMemberStatisticsInfo.setAttendCount(100);
        umsMemberStatisticsInfo.setRecentOrderTime(new Date());
        int addUmsMember = userAdminDao.addUmsMember(umsMemberStatisticsInfo);
        int a = 100 / 0;
        if (addUmsMember > 0) {
            return "成功";
        }
        return "失败";
    }
}
