package com.uxtc.cloud.in;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 鱼仔
 * @date 2021/6/10 4:10 下午
 * @description 客户端详细信息表
 */
@Data
public class OauthClientDetailIn implements Serializable {

    private static final long serialVersionUID = 1L;

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

    public OauthClientDetailIn() {
    }
}