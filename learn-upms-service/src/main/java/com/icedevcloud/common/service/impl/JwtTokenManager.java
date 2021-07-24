package com.icedevcloud.common.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.icedevcloud.common.config.JwtConfig;
import com.icedevcloud.common.entity.WxUserInfo;
import com.icedevcloud.common.service.ITokenManager;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.TimeUnit;

@Service
public class JwtTokenManager implements ITokenManager {

    private static final String INTEGRAL_TOKEN_KEY = "TOKEN:";

    @Autowired
    private JwtConfig jwtConfig;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private HttpServletRequest request;

    @Override
    public String getToken(WxUserInfo wxUserInfo) {
        stringRedisTemplate.opsForValue().set(INTEGRAL_TOKEN_KEY + wxUserInfo.getId(), JSONObject.toJSONString(wxUserInfo), jwtConfig.getTtl(), TimeUnit.MILLISECONDS);
        String jwt = jwtConfig.createJWT(String.valueOf(wxUserInfo.getId()), wxUserInfo.getId().toString());
        return jwt;
    }

    @Override
    public void refreshUserToken(String token) {
        Claims claims = jwtConfig.parseJWT(token);
        String id = claims.getId();
        stringRedisTemplate.expire(INTEGRAL_TOKEN_KEY + id, jwtConfig.getTtl(), TimeUnit.MILLISECONDS);
    }

    @Override
    public void logout(String token) {
        Claims claims = jwtConfig.parseJWT(token);
        String id = claims.getId();
        stringRedisTemplate.delete(INTEGRAL_TOKEN_KEY + id);
    }

    @Override
    public WxUserInfo getUserInfoByToken(String token) {
        Claims claims = jwtConfig.parseJWT(token);
        String id = claims.getId();
        String wxUserInfoStr = stringRedisTemplate.opsForValue().get(INTEGRAL_TOKEN_KEY + id);
        if (StringUtils.isEmpty(wxUserInfoStr)) {
            return null;
        }
        WxUserInfo wxUserInfo = JSONObject.parseObject(wxUserInfoStr, WxUserInfo.class);
        return wxUserInfo;
    }

    @Override
    public WxUserInfo getCurrentUserInfo() {
        WxUserInfo userInfo = (WxUserInfo) request.getAttribute("userInfo");
        return userInfo;
    }

}