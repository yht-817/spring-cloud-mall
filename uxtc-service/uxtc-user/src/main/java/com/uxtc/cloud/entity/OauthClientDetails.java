package com.uxtc.cloud.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 鱼仔
 * @date 2021/6/10 4:10 下午
 * @description 客户端详细信息表
 */
@Data
public class OauthClientDetails implements Serializable {

    private static final long serialVersionUID = 1L;

    private String clientId;

    /**
     * 客户端所能访问的资源id集合，多个资源时用逗号(，)
     */
    private String resourceIds;

    /**
     * 客户端访问密匙
     */
    private String clientSecret;

    /**
     * 客户端申请的权限范围
     */
    private String scope;

    /**
     * 客户端支持的授权许可类型(grant_type)，可选值包括authorization_code，password，refresh_token，implicit，client_credentials，若支持多个授权许可类型用逗号(，)
     */
    private String authorizedGrantTypes;

    /**
     * 客户端重定向uri，当grant_type为authorization_code或implicit时
     */
    private String webServerRedirectUri;

    /**
     * 客户端所拥有的spring security的权限值
     */
    private String authorities;

    /**
     * access_token的有效时间值(单位:秒)
     */
    private Integer accessTokenValidity;

    /**
     * refresh_token的有效时间值(单位:秒)
     */
    private Integer refreshTokenValidity;

    /**
     * 预留的字段
     */
    private String additionalInformation;

    /**
     * 设置用户是否自动批准授予权限操作， 默认值为 ‘false’， 可选值包括 ‘true’，‘false’， ‘read’，‘write’.
     */
    private String autoapprove;

    /**
     * create_time
     */
    private Date createTime;

    public OauthClientDetails() {
    }
}