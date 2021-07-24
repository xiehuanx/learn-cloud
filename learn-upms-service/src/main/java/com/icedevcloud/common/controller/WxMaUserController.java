package com.icedevcloud.common.controller;

import com.icedevcloud.common.core.api.R;
import com.icedevcloud.common.core.exception.ApiException;
import com.icedevcloud.common.entity.WxUserInfo;
import com.icedevcloud.common.service.ITokenManager;
import com.icedevcloud.common.service.IWxUserInfoService;
import com.icedevcloud.miniapp.dto.auth.LogInResDto;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.bean.WxOAuth2UserInfo;
import me.chanjar.weixin.common.bean.oauth2.WxOAuth2AccessToken;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/wx/user/")
public class WxMaUserController {

    @Autowired
    private IWxUserInfoService iWxUserInfoService;

    @Autowired
    private WxMpService wxService;

    @Autowired
    private ITokenManager iTokenManager;

    @ApiOperation(value = "accessToken")
    @GetMapping("/{appid}/accessToken")
    public R<LogInResDto> accessToken(@PathVariable String appid, @RequestParam(required = true) String code) {
        if (!this.wxService.switchover(appid)) {
            throw new ApiException(String.format("未找到对应appid=[%s]的配置，请核实！", appid));
        }

        try {
            WxOAuth2AccessToken accessToken = wxService.getOAuth2Service().getAccessToken(code);
            WxOAuth2UserInfo wxOAuth2UserInfo = wxService.getOAuth2Service().getUserInfo(accessToken, null);

            LogInResDto logInResDto = iWxUserInfoService.accessToken(wxOAuth2UserInfo);
            return R.ok(logInResDto);
        } catch (WxErrorException e) {
            e.printStackTrace();
            throw new ApiException("登录失败");
        }
    }

    @ApiOperation(value = "currentUserInfo")
    @PostMapping("currentUserInfo")
    public R<WxUserInfo> currentUserInfo() {
        WxUserInfo currentUserInfo = iTokenManager.getCurrentUserInfo();
        WxUserInfo wxUserInfo = iWxUserInfoService.currentUserInfo(currentUserInfo.getId());
        return R.ok(wxUserInfo);
    }

}
