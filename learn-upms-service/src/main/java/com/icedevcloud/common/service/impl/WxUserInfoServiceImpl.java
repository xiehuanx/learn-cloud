package com.icedevcloud.common.service.impl;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.icedevcloud.common.controller.BaseAreaController;
import com.icedevcloud.common.entity.WxUserInfo;
import com.icedevcloud.common.mapper.WxUserInfoMapper;
import com.icedevcloud.common.service.ITokenManager;
import com.icedevcloud.common.service.IWxUserInfoService;
import com.icedevcloud.cp.dto.order.ActivityOrderByPageReqDto;
import com.icedevcloud.cp.dto.order.ActivityOrderByPageRespDto;
import com.icedevcloud.cp.dto.order.WxUserInfoPageReqDto;
import com.icedevcloud.miniapp.dto.WxUserInfoReqDto;
import com.icedevcloud.miniapp.dto.auth.LogInResDto;
import me.chanjar.weixin.common.bean.WxOAuth2UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author XiaoBingBy
 * @since 2020-09-29
 */
@Service
public class WxUserInfoServiceImpl extends ServiceImpl<WxUserInfoMapper, WxUserInfo> implements IWxUserInfoService {

    @Autowired
    private ITokenManager iTokenManager;
    @Autowired
    private WxUserInfoMapper wxUserInfoMapper;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public LogInResDto accessToken(WxOAuth2UserInfo wxOAuth2UserInfo) {
        WxUserInfo wxUserInfo = this.getOne(Wrappers.<WxUserInfo>
                lambdaQuery().eq(WxUserInfo::getOpenId, wxOAuth2UserInfo.getOpenid())
        );
        if (wxUserInfo == null) {
            wxUserInfo = new WxUserInfo();
            wxUserInfo.setOpenId(wxOAuth2UserInfo.getOpenid());
            wxUserInfo.setUnionId(wxOAuth2UserInfo.getUnionId());
            wxUserInfo.setNickName(wxOAuth2UserInfo.getNickname());
            wxUserInfo.setAvatarUrl(wxOAuth2UserInfo.getHeadImgUrl());
            wxUserInfo.setCountry(wxOAuth2UserInfo.getCountry());
            wxUserInfo.setCity(wxOAuth2UserInfo.getCity());
            wxUserInfo.setProvince(wxOAuth2UserInfo.getProvince());
        } else {
            wxUserInfo.setOpenId(wxOAuth2UserInfo.getOpenid());
            wxUserInfo.setUnionId(wxOAuth2UserInfo.getUnionId());
            wxUserInfo.setNickName(wxOAuth2UserInfo.getNickname());
            wxUserInfo.setAvatarUrl(wxOAuth2UserInfo.getHeadImgUrl());
            wxUserInfo.setCountry(wxOAuth2UserInfo.getCountry());
            wxUserInfo.setCity(wxOAuth2UserInfo.getCity());
            wxUserInfo.setProvince(wxOAuth2UserInfo.getProvince());
        }
        this.saveOrUpdate(wxUserInfo);

        String token = iTokenManager.getToken(wxUserInfo);
        LogInResDto logInResDto = new LogInResDto();
        logInResDto.setToken(token);
        if (!StrUtil.isBlank(wxUserInfo.getCityAreaCode())) {
            String[] split = wxUserInfo.getCityAreaCode().split(",");
            wxUserInfo.setCityAreaCodeStr(BaseAreaController.map.get(split[0]) + "-" + BaseAreaController.map.get(split[1]));
            wxUserInfo.setAreaCodeStr(BaseAreaController.map.get(wxUserInfo.getAreaCode()));
        }
        logInResDto.setWxUserInfo(wxUserInfo);
        return logInResDto;
    }


    @Override
    public IPage<WxUserInfo> queryWxUSerInfo(WxUserInfoReqDto wxUserInfoReqDto) {
        Page<WxUserInfo> page = new Page(wxUserInfoReqDto.getCurrent(), wxUserInfoReqDto.getPageSize());
        LambdaQueryWrapper<WxUserInfo> wxUserInfoLambdaQueryWrapper = Wrappers.lambdaQuery();
        //isvip == 1,说明了注册用户的VIP在有效的，即当前时间大于VIP生效时间，小于VIP失效时间
        String now = DateUtil.now();
        if (StrUtil.isNotBlank(wxUserInfoReqDto.getNickName())) {
            wxUserInfoLambdaQueryWrapper.like(WxUserInfo::getNickName, wxUserInfoReqDto.getNickName());
        }
        if (StrUtil.isNotBlank(wxUserInfoReqDto.getGender())) {
            wxUserInfoLambdaQueryWrapper.like(WxUserInfo::getGender, wxUserInfoReqDto.getGender());
        }
        if (StrUtil.isNotBlank(wxUserInfoReqDto.getCity())) {
            wxUserInfoLambdaQueryWrapper.like(WxUserInfo::getCity, wxUserInfoReqDto.getCity());
        }
        if (StrUtil.isNotBlank(wxUserInfoReqDto.getPhoneNumber())) {
            wxUserInfoLambdaQueryWrapper.like(WxUserInfo::getPhoneNumber, wxUserInfoReqDto.getPhoneNumber());
        }
        IPage<WxUserInfo> result = this.page(page, wxUserInfoLambdaQueryWrapper);
        return result;
    }

    @Override
    public WxUserInfo currentUserInfo(Long id) {
        WxUserInfo wxUserInfo = this.getById(id);
        return wxUserInfo;
    }

    @Override
    public IPage<WxUserInfo> userInfoPage(WxUserInfoPageReqDto wxUserInfoPageReqDto) {
        Page<WxUserInfo> page = new Page<>(wxUserInfoPageReqDto.getCurrent(), wxUserInfoPageReqDto.getPageSize());
        WxUserInfoPageReqDto.QueryParam queryParam = wxUserInfoPageReqDto.getQueryParam();
        IPage<WxUserInfo> activityOrderByPageRespDtoIPage = wxUserInfoMapper.userInfoPage(page, queryParam.getNickName(),
                queryParam.getPhoneNumber(), queryParam.getBirthDateStartStr(), queryParam.getBirthDateEndStr(), queryParam.getDegreeMin(),
                queryParam.getDegreeMax(), queryParam.getCityAreaCode(), queryParam.getAreaCode(), queryParam.getGender());
        for (WxUserInfo record : activityOrderByPageRespDtoIPage.getRecords()) {
            String[] split = record.getCityAreaCode().split(",");
            record.setCityAreaCode(BaseAreaController.map.get(split[0]) + "-" + BaseAreaController.map.get(split[1]));
            record.setAreaCode(BaseAreaController.map.get(record.getAreaCode()));
        }
        return activityOrderByPageRespDtoIPage;
    }

}
