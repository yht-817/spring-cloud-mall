package com.uxtc.user.cloud.service.impl;

import cn.hutool.core.util.IdUtil;
import com.uxtc.user.cloud.entity.OauthClientDetails;
import com.uxtc.user.cloud.entity.UmsMemberStatisticsInfo;
import com.uxtc.user.cloud.in.OauthClientDetailIn;
import com.uxtc.user.cloud.service.UserAdminService;
import com.uxtc.user.cloud.dao.UserAdminDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

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
    public int addUmsMember() {
        UmsMemberStatisticsInfo umsMemberStatisticsInfo = new UmsMemberStatisticsInfo();
        umsMemberStatisticsInfo.setMemberId((long) Math.random());
        umsMemberStatisticsInfo.setAttendCount(100);
        umsMemberStatisticsInfo.setRecentOrderTime(new Date());
        return userAdminDao.addUmsMember(umsMemberStatisticsInfo);
    }
}
