package com.icedevcloud.upms.controller;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.icedevcloud.common.core.api.R;
import com.icedevcloud.cp.dto.order.WxUserInfoPageReqDto;
import com.icedevcloud.miniapp.dto.WxUserInfoReqDto;
import com.icedevcloud.common.entity.WxUserInfo;
import com.icedevcloud.common.service.IWxUserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * author :xiehuan
 * Email: 1487471733@qq.com
 * Date: 2020/11/17
 * Describe:
 */
@Slf4j
@RestController
@RequestMapping("/upms/wx/user/")
public class WxUSerInfoController {

    @Autowired
    private IWxUserInfoService iWxUserInfoService;


    /**
     * 根据逐渐查询用户信息
     * @param id
     * @return
     */
    @PostMapping("/{id}")
    public R<WxUserInfo> queryWxUSerInfo(@PathVariable(required = true, name = "id") Long id) {
        return R.ok(iWxUserInfoService.getById(id));
    }


}
