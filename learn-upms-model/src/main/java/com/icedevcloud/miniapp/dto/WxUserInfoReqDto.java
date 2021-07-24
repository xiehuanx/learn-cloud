package com.icedevcloud.miniapp.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * author :xiehuan
 * Email: 1487471733@qq.com
 * Date: 2020/11/17
 * Describe: 小程序管理后台 小程序用户管理入参参数类
 */
@Data
public class WxUserInfoReqDto implements Serializable {

    @ApiModelProperty(value = "页码")
    private Long current = 1L;
    @ApiModelProperty(value = "每一页的数据量")
    private Long pageSize = 10L;
    @ApiModelProperty(value = "昵称")
    private String nickName;
    /**
     * 用户性别 0 未知 1 男性 2 女性
     */
    @ApiModelProperty(value = "用户性别 0 未知 1 男性 2 女性")
    private String gender;
    @ApiModelProperty(value = "用户所在城市")
    private String city;
    @ApiModelProperty(value = "用户绑定的手机号（国外手机号会有区号）")
    private String phoneNumber;
    /**
     * 是否是VIP， 0-不是VIP；1-是VIP
     */
    @ApiModelProperty(value = "是否是VIP， 0-不是VIP；1-是VIP")
    private Integer isVip;

}
