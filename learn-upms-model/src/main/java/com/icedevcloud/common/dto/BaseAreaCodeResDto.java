package com.icedevcloud.common.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel("地区Tree返回参数")
@Data
public class BaseAreaCodeResDto {

    @ApiModelProperty(value = "一级地区码")
    private String oneAreaCode;

    @ApiModelProperty(value = "二级地区码")
    private String twoAreaCode;

    @ApiModelProperty(value = "三级地区码")
    private String threeAreaCode;

}
