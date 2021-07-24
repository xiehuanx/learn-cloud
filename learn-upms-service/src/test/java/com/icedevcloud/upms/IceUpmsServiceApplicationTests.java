package com.icedevcloud.upms;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.icedevcloud.common.core.api.R;
import com.icedevcloud.cp.dto.order.ActivityInvitationPageAllCpGroupByGenderRespDto;
import com.icedevcloud.cp.dto.order.ActivityInvitationPageCpReqDto;
import com.icedevcloud.cp.dto.order.ActivityInvitationPageRespDto;
import com.icedevcloud.cp.dto.order.ActivityOrderStatusRespDto;
import com.icedevcloud.cp.entity.ActivityOrder;
import com.icedevcloud.cp.enums.ActivityOrderStatusEnums;
import com.icedevcloud.mp.config.WxMpProperties;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateData;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;
import me.chanjar.weixin.mp.config.WxMpConfigStorage;
import org.apache.commons.lang.RandomStringUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class IceUpmsServiceApplicationTests {



    @Autowired
    private WxMpProperties properties;

    @Autowired
    protected WxMpService wxService;



    @Test
    public void contextLoads() throws WxErrorException {
//        String str = "{\"appid\":\"wx88c75ddb7c18587e\",\"goodsName\":\"CP报名费用\",\"openid\":\"odqB81LOR2kIL50nCIYRkqTNvTpA\",\"orderNo\":\"AO1386600376907616259\",\"totalAmount\":1}";
//        WxPayMpReqDto wxPayMpReqDto = JSON.parseObject(str, WxPayMpReqDto.class);
//        wxPayMpReqDto.setOpenid("odqB81Cf-7MDZcAVwEzI0Dp9gL8U");
//        wxPayMpReqDto.setIpAddress("111.230.70.100");
//        WxPayMpResDto pay = iPayCenterService.pay(wxPayMpReqDto, 42L, null);

//        ActivityOrderStatusRespDto activityOrderStatus = iActivityOrderService.getActivityOrderStatus("de81d07c-1395-459c-b779-c1ed470230d5");
//        System.out.println(activityOrderStatus);

//        ActivityOrder activityOrder = new ActivityOrder();
//        activityOrder.setOrderStatus("X");
//        activityOrderService.update(activityOrder, Wrappers.<ActivityOrder>lambdaQuery().eq(ActivityOrder::getOrderNo, "AO1387398874825605121"));

        Long a = 0L;

        System.out.println(a.equals(0L));

    }

}
