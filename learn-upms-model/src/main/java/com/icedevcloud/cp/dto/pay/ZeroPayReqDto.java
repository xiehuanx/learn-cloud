package com.icedevcloud.cp.dto.pay;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel("零元支付请求参数")
@Data
public class ZeroPayReqDto {

    @ApiModelProperty("订单号")
    private String orderNo;

}
