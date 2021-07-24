package com.icedevcloud.miniapp.dto.user;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 用户金额信息
 *
 * @author XiaoBingBy
 * @since 2020-12-27
 */
@Builder
@Data
public class UserAmountInfoResDto {

    @ApiModelProperty(value = "用户可提现金额")
    private BigDecimal userTotalAmount;

    @ApiModelProperty(value = "用户总收益")
    private BigDecimal userHistoryTotalAmount;

    @ApiModelProperty(value = "用户昨天收益")
    private BigDecimal userYesterDayAmount;

}
