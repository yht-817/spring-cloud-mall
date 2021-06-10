package com.uxtc.userfg.cloud.user;

import com.uxtc.common.cloud.entity.UserDto;
import lombok.extern.slf4j.Slf4j;

/**
 * @author 鱼仔
 * @date 2021/4/22 11:08 上午
 * Feign失败配置
 */
@Slf4j
public class IUserAdminFallback implements IUserAdminClient {
    @Override
    public int addUmsMember() {
        return 0;
    }
}
