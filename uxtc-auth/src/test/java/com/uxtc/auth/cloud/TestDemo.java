package com.uxtc.auth.cloud;

import cn.hutool.core.collection.CollectionUtil;
import com.uxtc.auth.cloud.entity.RoleResources;
import com.uxtc.auth.cloud.mapper.UserServiceDao;
import com.uxtc.common.cloud.constant.AuthConstant;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author 鱼仔
 * @date 2021/6/11 1:12 下午
 * 概要
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class TestDemo {

    @Autowired
    UserServiceDao dao;

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 存储对象
     */
    @Test
    public void demo() {
        List<RoleResources> resources = dao.getRoleList();
        log.error("查询的参数：{}", resources.toString());
        Map<String, List<String>> treeMap = new TreeMap<>();
        Optional.ofNullable(resources).orElse(new ArrayList<>()).forEach(resource -> {
            List<String> roleList = Optional.ofNullable(resource.getRoleIds()).orElse(new ArrayList<>())
                    .stream().map(roleId -> AuthConstant.AUTHORITY_PREFIX + roleId).collect(Collectors.toList());
            if (CollectionUtil.isNotEmpty(roleList)) {
                treeMap.put(resource.getUrl(), roleList);
            }
            log.error("组装的map:{}", treeMap.toString());
            redisTemplate.opsForHash().putAll(AuthConstant.RESOURCE_ROLES_MAP_KEY, treeMap);
        });
    }
}
