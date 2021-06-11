package com.uxtc.user.cloud.service.impl;

import cn.hutool.core.util.IdUtil;
import com.uxtc.user.cloud.entity.OauthClientDetails;
import com.uxtc.user.cloud.dao.OauthClientDetailsDao;
import com.uxtc.user.cloud.service.OauthClientDetailsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 客户端详细信息表(OauthClientDetails)表服务实现类
 *
 * @author makejava
 * @since 2021-06-10 16:49:00
 */
@Service("oauthClientDetailsService")
public class OauthClientDetailsServiceImpl implements OauthClientDetailsService {
    @Resource
    private OauthClientDetailsDao oauthClientDetailsDao;

    /**
     * 通过ID查询单条数据
     *
     * @param clientId 主键
     * @return 实例对象
     */
    @Override
    public OauthClientDetails queryById(String clientId) {
        return this.oauthClientDetailsDao.queryById(clientId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<OauthClientDetails> queryAllByLimit(int offset, int limit) {
        return this.oauthClientDetailsDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param oauthClientDetails 实例对象
     * @return 实例对象
     */
    @Override
    public OauthClientDetails insert(OauthClientDetails oauthClientDetails) {
        oauthClientDetails.setClientId(IdUtil.simpleUUID());
        this.oauthClientDetailsDao.insert(oauthClientDetails);
        return oauthClientDetails;
    }

    /**
     * 修改数据
     *
     * @param oauthClientDetails 实例对象
     * @return 实例对象
     */
    @Override
    public OauthClientDetails update(OauthClientDetails oauthClientDetails) {
        this.oauthClientDetailsDao.update(oauthClientDetails);
        return this.queryById(oauthClientDetails.getClientId());
    }

    /**
     * 通过主键删除数据
     *
     * @param clientId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String clientId) {
        return this.oauthClientDetailsDao.deleteById(clientId) > 0;
    }
}