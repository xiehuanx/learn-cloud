package com.icedevcloud.cp.dto.order;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel("参加活动下单返回参")
@Data
public class CreateActivityOrderResDto {

    @ApiModelProperty(value = "订单号")
    private String orderNo;

}
