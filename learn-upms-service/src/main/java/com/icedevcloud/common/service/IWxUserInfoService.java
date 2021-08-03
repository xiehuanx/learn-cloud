package com.icedevcloud.common.service;

import cn.binarywang.wx.miniapp.bean.WxMaPhoneNumberInfo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.icedevcloud.common.entity.WxUserInfo;
import com.icedevcloud.cp.dto.order.WxUserInfoPageReqDto;
import com.icedevcloud.miniapp.dto.WxUserInfoReqDto;
import com.icedevcloud.miniapp.dto.auth.LogInReqDto;
import com.icedevcloud.miniapp.dto.auth.LogInResDto;
import me.chanjar.weixin.common.bean.WxOAuth2UserInfo;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author XiaoBingBy
 * @since 2020-09-29
 */
public interface IWxUserInfoService extends IService<WxUserInfo> {

    /**
     * 登陆接口
     *
     * @param logInReqDto
     * @return
     */
    LogInResDto loginToken(LogInReqDto logInReqDto);

    /**
     * accessToken
     *
     * @param wxOAuth2UserInfo
     * @return
     */
    LogInResDto accessToken(WxOAuth2UserInfo wxOAuth2UserInfo);

    /**
     * 分页查询用户数据
     *
     * @param wxUserInfoReqDto
     * @return
     */
    IPage<WxUserInfo> queryWxUSerInfo(WxUserInfoReqDto wxUserInfoReqDto);

    /**
     * 当前用户信息
     *
     * @param id
     * @return
     */
    WxUserInfo currentUserInfo(Long id);



}
