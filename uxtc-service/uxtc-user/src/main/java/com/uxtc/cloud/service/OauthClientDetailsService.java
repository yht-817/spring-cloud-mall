package com.uxtc.cloud.service;

import com.uxtc.cloud.entity.OauthClientDetails;

import java.util.List;

/**
 * 客户端详细信息表(OauthClientDetails)表服务接口
 *
 * @author makejava
 * @since 2021-06-10 16:49:00
 */
public interface OauthClientDetailsService {

    /**
     * 通过ID查询单条数据
     *
     * @param clientId 主键
     * @return 实例对象
     */
    OauthClientDetails queryById(String clientId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<OauthClientDetails> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param oauthClientDetails 实例对象
     * @return 实例对象
     */
    OauthClientDetails insert(OauthClientDetails oauthClientDetails);

    /**
     * 修改数据
     *
     * @param oauthClientDetails 实例对象
     * @return 实例对象
     */
    OauthClientDetails update(OauthClientDetails oauthClientDetails);

    /**
     * 通过主键删除数据
     *
     * @param clientId 主键
     * @return 是否成功
     */
    boolean deleteById(String clientId);

}