package com.uxtc.cloud.controller;

import com.uxtc.cloud.domain.Oauth2TokenDto;
import com.uxtc.cloud.common.api.CommonResult;
import com.uxtc.cloud.common.constant.AuthConstant;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.endpoint.TokenEndpoint;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.security.Principal;
import java.util.Map;

/**
 * 自定义Oauth2获取令牌接口
 *
 * @author 鱼仔
 * @date 2020/7/17
 */
@RestController
@Api(tags = "AuthController", description = "认证中心登录认证")
@RequestMapping("/oauth")
public class AuthController {

    @Autowired
    TokenEndpoint tokenEndpoint;


    @ApiOperation("用户密码获取token")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "grant_type", value = "授权模式", required = true),
            @ApiImplicitParam(name = "client_id", value = "Oauth2客户端ID", required = true),
            @ApiImplicitParam(name = "client_secret", value = "Oauth2客户端秘钥", required = true),
            @ApiImplicitParam(name = "refresh_token", value = "刷新token"),
            @ApiImplicitParam(name = "username", value = "登录用户名"),
            @ApiImplicitParam(name = "password", value = "登录密码")
    })
    @RequestMapping(value = "/token", method = RequestMethod.POST)
    public CommonResult<Oauth2TokenDto> postAccessToken(@ApiIgnore Principal principal, @ApiIgnore @RequestParam Map<String, String> parameters) throws HttpRequestMethodNotSupportedException {
        OAuth2AccessToken oAuth2AccessToken = tokenEndpoint.postAccessToken(principal, parameters).getBody();
        Oauth2TokenDto oauth2TokenDto = Oauth2TokenDto.builder()
                .token(oAuth2AccessToken.getValue())
                .refreshToken(oAuth2AccessToken.getRefreshToken() == null ? "" : oAuth2AccessToken.getRefreshToken().getValue())
                .expiresIn(oAuth2AccessToken.getExpiresIn())
                .tokenHead(AuthConstant.JWT_TOKEN_PREFIX).build();
        return CommonResult.success(oauth2TokenDto);
    }


//
//    @ApiOperation("code授权获取token")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "grant_type", value = "授权模式", required = true),
//            @ApiImplicitParam(name = "client_id", value = "Oauth2客户端ID", required = true),
//            @ApiImplicitParam(name = "client_secret", value = "Oauth2客户端秘钥", required = true),
//            @ApiImplicitParam(name = "code", value = "Oauth2客户端ID", required = true)
//    })
//    @RequestMapping(value = "/codeToken", method = RequestMethod.POST)
//    public CommonResult<Oauth2TokenDto> postCodeToken(@ApiIgnore Principal principal, @ApiIgnore @RequestParam Map<String, String> parameters) throws HttpRequestMethodNotSupportedException {
//        MultiValueMap<String, Object> paramsMap = new LinkedMultiValueMap<>();
//        paramsMap.set("code", parameters.get("code"));
//        paramsMap.set("grant_type", parameters.get("grant_type"));
//        RestTemplate restTemplate = new RestTemplate();
//        restTemplate.getInterceptors().add(new BasicAuthenticationInterceptor(parameters.get("client_id").toString(), parameters.get("client_secret").toString()));
//        OAuth2AccessToken token = restTemplate.postForObject("http://127.0.0.1:8401/oauth/token", paramsMap, OAuth2AccessToken.class);
//        Oauth2TokenDto oauth2TokenDto = Oauth2TokenDto.builder()
//                .token(token.getValue())
//                .expiresIn(token.getExpiresIn())
//                .tokenHead(AuthConstant.JWT_TOKEN_PREFIX).build();
//        return CommonResult.success(oauth2TokenDto);
//    }
}