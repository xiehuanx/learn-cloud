package com.icedevcloud.cp.dto.order;

import com.icedevcloud.common.entity.WxUserInfo;
import com.icedevcloud.cp.entity.ActivityOrder;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * author :xie.huan
 * Email: 1487471733@qq.com
 * Date: 2021/4/12
 * Describe:
 */
@Data
public class WxUserInfoPageRespDto extends ActivityOrder implements Serializable {

    @ApiModelProperty(value = "用户昵称")
    private String nickName;

    @ApiModelProperty(value = "用户头像")
    private String avatarUrl;


}
