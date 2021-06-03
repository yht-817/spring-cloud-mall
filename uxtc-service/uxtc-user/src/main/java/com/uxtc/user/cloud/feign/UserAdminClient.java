package com.uxtc.user.cloud.feign;

import com.uxtc.common.cloud.entity.UserDto;
import com.uxtc.user.cloud.service.UserAdminService;
import com.uxtc.userfg.cloud.user.IUserAdminClient;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 鱼仔
 * @date 2021/4/22 11:22 上午
 * 用户服务的Feign实现类
 */
@RestController
@AllArgsConstructor
public class UserAdminClient implements IUserAdminClient {

    @Autowired
    UserAdminService userAdminService;

    @Override
    @GetMapping("/user/loadByUsername")
    public UserDto loadUserByUsername(Long userId) {
        return userAdminService.loadUserByUsername(userId);
    }
}
