package com.icedevcloud.cp.dto.order;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * author :xiehuan
 * Email: 1487471733@qq.com
 * Date: 2021/4/19
 * Describe:
 */
@Data
public class ActivityInvitationPageAllCpGroupByGenderRespDto implements Serializable {

    /**
     * 男生数据
     */
    @ApiModelProperty(value = "男生数据")
    private List<ActivityInvitationPageCpRespDto> boys;

    /**
     * 女生数据
     */
    @ApiModelProperty(value = "女生数据")
    private List<ActivityInvitationPageCpRespDto> girls;


    @ApiModelProperty(value = "无性别")
    private List<ActivityInvitationPageCpRespDto> noGenders;

    private String activityAddress;


    private String sloganContent;

    @ApiModelProperty(value = "号码")
    private Integer userNumber;

}
