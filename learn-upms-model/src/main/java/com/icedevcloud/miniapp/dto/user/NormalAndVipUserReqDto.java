package com.icedevcloud.miniapp.dto.user;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * author :xiehuan
 * Email: 1487471733@qq.com
 * Date: 2020/12/26
 * Describe:
 */
@Data
public class NormalAndVipUserReqDto {

    @ApiModelProperty(value = "id")
    private Long id;

    @ApiModelProperty(value = "用户昵称")
    private String nickName;

    @ApiModelProperty(value = "用户头像")
    private String avatarUrl;

    @ApiModelProperty(value = "创建时间")
    private Date gmtCreate;

    @ApiModelProperty(value = "vip生效时间")
    private Date vipEffDate;

    @ApiModelProperty(value = "vip失效时间")
    private Date vipExpDate;

    @ApiModelProperty(value = "VIP 用户类型 MC-月会员 QC-季会员 YC-年会员")
    private String vipUserType;

}
