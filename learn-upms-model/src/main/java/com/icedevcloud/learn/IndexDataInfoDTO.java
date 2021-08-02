package com.icedevcloud.learn;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * author :xiehuan
 * Email: 1487471733@qq.com
 * Date: 2021/8/2
 * Describe:
 * 首页的进度，积分，以及天数
 */
@Data
public class IndexDataInfoDTO implements Serializable {
    private static final long serialVersionUID = 735783347821636689L;

    @ApiModelProperty(value = "进度")
    private String speed;

    @ApiModelProperty(value = "积分")
    private Integer integral;

    @ApiModelProperty(value = "天数")
    private Integer days;
}
