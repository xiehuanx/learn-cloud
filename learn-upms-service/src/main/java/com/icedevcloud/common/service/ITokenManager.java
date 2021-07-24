package com.icedevcloud.common.service;


import com.icedevcloud.common.entity.WxUserInfo;

public interface ITokenManager {

    /**
     * 创建token
     *
     * @param wxUserInfo
     * @return
     */
    String getToken(WxUserInfo wxUserInfo);

    /**
     * 刷新用户
     *
     * @param token
     */
    void refreshUserToken(String token);

    /**
     * 用户退出
     *
     * @param token
     */
    void logout(String token);

    /**
     * 获取用户信息
     *
     * @param token
     * @return
     */
    WxUserInfo getUserInfoByToken(String token);

    /**
     * 获取当前用户信息
     *
     * @return
     */
    WxUserInfo getCurrentUserInfo();

}