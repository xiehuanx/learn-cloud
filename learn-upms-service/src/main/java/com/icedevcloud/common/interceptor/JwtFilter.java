package com.icedevcloud.common.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.icedevcloud.common.core.api.R;
import com.icedevcloud.common.entity.WxUserInfo;
import com.icedevcloud.common.service.ITokenManager;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

@Component
public class JwtFilter extends HandlerInterceptorAdapter {

    @Autowired
    private ITokenManager iTokenManager;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        final String authHeader = request.getHeader("Authorization");

        if (authHeader != null && !authHeader.isEmpty()) {
            try {
                WxUserInfo userInfoByToken = iTokenManager.getUserInfoByToken(authHeader);
                if (userInfoByToken != null) {
                    request.setAttribute("userInfo", userInfoByToken);
                    return true;
                }
            } catch (ExpiredJwtException e) {
                e.printStackTrace();
            }
        }

        R<Object> r = R.failed("no authorization");
        response.setStatus(401);
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");

        PrintWriter writer = null;
        try {
            writer = response.getWriter();
            writer.append(JSONObject.toJSONString(r));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            writer.close();
        }
        return false;
    }

}