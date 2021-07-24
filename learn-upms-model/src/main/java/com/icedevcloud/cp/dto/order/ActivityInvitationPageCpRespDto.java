package com.icedevcloud.cp.dto.order;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * author :xiehuan
 * Email: 1487471733@qq.com
 * Date: 2021/4/19
 * Describe:
 */
@Data
public class ActivityInvitationPageCpRespDto implements Serializable {


    @ApiModelProperty(value = "活动编号")
    private String activityNo;


    @ApiModelProperty(value = "身高")
    private Integer height;


    @ApiModelProperty(value = "体重")
    private Integer weight;


    @ApiModelProperty(value = "学历")
    private Integer degree;

    @JsonFormat(pattern = "yyyy-MM", timezone = "GMT+8")
    @ApiModelProperty(value = "出生年月")
    private Date birthDate;


    @ApiModelProperty(value = "星座")
    private Integer constellation;


    @ApiModelProperty(value = "性别 0 未知 1 男性 2 女性")
    private Integer gender;

    @ApiModelProperty(value = "用户昵称")
    private String nickName;

    @ApiModelProperty(value = "用户头像")
    private String avatarUrl;

    @ApiModelProperty(value = "用户绑定的手机号（国外手机号会有区号）")
    private String phoneNumber;

    @ApiModelProperty(value = "微信号")
    private String wechatNumber;

    @ApiModelProperty(value = "关于我")
    private String aboutMe;

    @ApiModelProperty(value = "CP一句话")
    private String cpContent;

    @ApiModelProperty("号码")
    private Integer userNumber;

}
