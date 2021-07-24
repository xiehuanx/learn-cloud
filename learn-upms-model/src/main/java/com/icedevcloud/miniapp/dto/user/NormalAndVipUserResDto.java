package com.icedevcloud.miniapp.dto.user;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * author :xiehuan
 * Email: 1487471733@qq.com
 * Date: 2020/12/26
 * Describe:
 */
@Data
public class NormalAndVipUserResDto {

    @ApiModelProperty(value = "O 普通;V VIP")
    private String type;

}
