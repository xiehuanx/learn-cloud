package com.icedevcloud.miniapp.dto.user;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

/**
 * VIP 用户信息
 *
 * @author XiaoBingBy
 * @since 2020-12-20
 */
@Data
public class VipUserInfoResDto {

    @ApiModelProperty(value = "是否 VIP 用户标识")
    private Boolean vipUserFlag;

    @ApiModelProperty(value = "是否存在绑定关系 比奥少")
    private Boolean vipDistributionFlag;

    @ApiModelProperty(value = "vip生效时间")
    private Date vipEffDate;

    @ApiModelProperty(value = "vip失效时间")
    private Date vipExpDate;

    @ApiModelProperty(value = "VIP 用户类型 MC-月会员 QC-季会员 YC-年会员")
    private String vipUserType;

}
