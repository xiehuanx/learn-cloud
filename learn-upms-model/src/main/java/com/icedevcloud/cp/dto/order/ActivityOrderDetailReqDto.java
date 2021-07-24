package com.icedevcloud.cp.dto.order;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel("CP活动订单详情请求参数")
@Data
public class ActivityOrderDetailReqDto {

    @ApiModelProperty(value = "订单号")
    private String orderNo;

}
