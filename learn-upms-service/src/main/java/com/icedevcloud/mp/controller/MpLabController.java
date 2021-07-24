package com.icedevcloud.mp.controller;

import me.chanjar.weixin.common.bean.WxOAuth2UserInfo;
import me.chanjar.weixin.common.bean.oauth2.WxOAuth2AccessToken;
import me.chanjar.weixin.common.service.WxOAuth2Service;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.WxMpUserService;
import me.chanjar.weixin.mp.bean.result.WxMpUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/wx/lab/")
public class MpLabController {

    @Autowired
    private WxMpService wxService;

    @GetMapping("lab1/{appid}")
    public Object lab1(@PathVariable String appid) throws Exception {
        if (!this.wxService.switchover(appid)) {
            throw new IllegalArgumentException(String.format("未找到对应appid=[%s]的配置，请核实！", appid));
        }
        String accessToken = wxService.getAccessToken();
        return accessToken;
    }

    @GetMapping("accessToken/{code}")
    public Object apiAccessToken(@PathVariable String code) throws Exception {
        if (!this.wxService.switchover("wx88c75ddb7c18587e")) {
            throw new IllegalArgumentException(String.format("未找到对应appid=[%s]的配置，请核实！", "wx88c75ddb7c18587e"));
        }
        WxOAuth2Service oAuth2Service = wxService.getOAuth2Service();
        WxOAuth2AccessToken accessToken = oAuth2Service.getAccessToken(code);
        String openId = accessToken.getOpenId();
        WxOAuth2UserInfo wxOAuth2UserInfo = oAuth2Service.getUserInfo(accessToken, "zh_CN");
        return wxOAuth2UserInfo;
    }

}
