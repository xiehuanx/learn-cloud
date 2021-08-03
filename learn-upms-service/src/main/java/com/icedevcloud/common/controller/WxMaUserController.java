package com.icedevcloud.common.controller;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.api.WxMaUserService;
import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import cn.hutool.core.bean.BeanUtil;
import com.icedevcloud.common.core.api.R;
import com.icedevcloud.common.core.exception.ApiException;
import com.icedevcloud.common.entity.WxUserInfo;
import com.icedevcloud.common.service.ITokenManager;
import com.icedevcloud.common.service.IWxUserInfoService;
import com.icedevcloud.miniapp.config.WxMaConfiguration;
import com.icedevcloud.miniapp.dto.auth.LogInReqDto;
import com.icedevcloud.miniapp.dto.auth.LogInResDto;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.bean.WxOAuth2UserInfo;
import me.chanjar.weixin.common.bean.oauth2.WxOAuth2AccessToken;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.WxMpUserService;
import me.chanjar.weixin.mp.bean.result.WxMpUser;
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

    @ApiOperation(value = "登陆接口")
    @PostMapping("/{appid}/login")
    public R<LogInResDto> login(@PathVariable String appid, @RequestParam(required = true) String code) {

        final WxMaService wxService = WxMaConfiguration.getMaService(appid);
        LogInReqDto logInReqDto = new LogInReqDto();
        logInReqDto.setCode(code);
        WxMpUserService userService = this.wxService.getUserService();

        try {
            WxMaJscode2SessionResult session = wxService.getUserService().getSessionInfo(logInReqDto.getCode());
            WxMpUser wxMpUser = new WxMpUser();//userService.userInfo(session.getOpenid());
            BeanUtil.copyProperties(wxMpUser, logInReqDto);
            logInReqDto.setGender(wxMpUser.getSex() + "");
            log.info("【SessionKey】 {}", session.getSessionKey());
            log.info("【Openid】 {}", session.getOpenid());
            log.info("【Unionid】 {}", session.getUnionid());
            log.info(session.getSessionKey());
            logInReqDto.setOpenId(session.getOpenid());
            logInReqDto.setUnionId(session.getUnionid());
            LogInResDto logInResDto = iWxUserInfoService.loginToken(logInReqDto);
            return R.ok(logInResDto);
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage(), e);
            throw new ApiException(e.getMessage());
        }
    }

    @ApiOperation(value = "currentUserInfo")
    @PostMapping("currentUserInfo")
    public R<WxUserInfo> currentUserInfo() {
        WxUserInfo currentUserInfo = iTokenManager.getCurrentUserInfo();
        WxUserInfo wxUserInfo = iWxUserInfoService.currentUserInfo(currentUserInfo.getId());
        return R.ok(wxUserInfo);
    }

    /**
     * 保存用户的邀请码
     * @param invitationCode 邀请码
     * @return true
     */
    @ApiOperation(value = "保存用户邀请码")
    @PostMapping("/saveUserInvitationCode")
    public R<Boolean> saveUserInvitationCode(@RequestParam("invitationCode") String  invitationCode) {
        WxUserInfo wxUserInfo = new WxUserInfo();
        wxUserInfo.setInvitationCode(invitationCode);
        wxUserInfo.setId(iTokenManager.getCurrentUserInfo().getId());
        return R.ok(iWxUserInfoService.updateById(wxUserInfo));
    }

}
