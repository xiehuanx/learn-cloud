package com.icedevcloud.common.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@ApiModel("地区Tree返回参数")
@Data
public class BaseAreaTreeResDto {

    @ApiModelProperty(value = "地区码")
    private String areaCode;

    @ApiModelProperty(value = "父地区码")
    private String parentAreaCode;

    @ApiModelProperty(value = "地区名称")
    private String areaName;

    @ApiModelProperty(value = "地区类型：0-无 1-省级地区 2-市级地区 3-区县级地区")
    private String areaType;

    @ApiModelProperty(value = "children")
    private List<BaseAreaTreeResDto> children;

}
