package com.icedevcloud.learn.controller;


import com.icedevcloud.common.core.api.R;
import com.icedevcloud.common.service.ITokenManager;
import com.icedevcloud.learn.entity.IntegralLog;
import com.icedevcloud.learn.service.IIntegralLogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author XiaoBingBy
 * @since 2021-07-25
 */
@Api(value = "积分管理接口类", tags = "积分管理", description = "积分管理")
@RestController
@RequestMapping("/learn/integralLog")
public class IntegralLogController {

    @Autowired
    private IIntegralLogService integralLogService;

    @Autowired
    private ITokenManager iTokenManager;

    /**
     * 小朋友答题后，登记做题结果，答对计1分，答错不计分
     * @param integralLog 日志
     * @return 是否成功
     */
    @ApiOperation(value = "答题登记积分", notes = "答题登记积分接口", produces = "application/json")
    @PostMapping("/save")
    public R<Boolean> saveUserIntergralLog(@RequestBody IntegralLog integralLog) {
        Long userId = iTokenManager.getCurrentUserInfo().getId();
        integralLog.setUserId(userId);
        return R.ok(integralLogService.save(integralLog));
    }



}
