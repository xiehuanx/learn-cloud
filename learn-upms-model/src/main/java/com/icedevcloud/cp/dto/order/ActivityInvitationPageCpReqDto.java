package com.icedevcloud.cp.dto.order;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * author :xiehuan
 * Email: 1487471733@qq.com
 * Date: 2021/4/19
 * Describe:
 */
@Data
public class ActivityInvitationPageCpReqDto implements Serializable {

    /**
     * 活动id
     */
    @ApiModelProperty(value = "活动id")
    private String activityNo;

    @ApiModelProperty(value = "性别")
    private Integer gender;
}
