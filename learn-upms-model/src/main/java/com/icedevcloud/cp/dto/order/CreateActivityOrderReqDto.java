package com.icedevcloud.cp.dto.order;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

@ApiModel("参加活动下单入参")
@Data
public class CreateActivityOrderReqDto {

    @NotBlank(message = "活动编号不能为空")
    @NotNull(message = "活动编号不能为空")
    @ApiModelProperty(value = "活动编号")
    private String activityNo;

    @NotNull(message = "身高不能为空")
    @ApiModelProperty(value = "身高")
    private Integer height;

    @NotNull(message = "体重不能为空")
    @ApiModelProperty(value = "体重")
    private Integer weight;

    @NotNull(message = "学历不能为空")
    @ApiModelProperty(value = "学历")
    private Integer degree;

    @NotNull(message = "出生年月不能为空")
    @JsonFormat(pattern = "yyyy-MM", timezone = "GMT+8")
    @ApiModelProperty(value = "出生年月")
    private Date birthDate;

    @NotNull(message = "星座不能为空")
    @ApiModelProperty(value = "星座")
    private Integer constellation;

    @NotNull(message = "性别不能为空")
    @ApiModelProperty(value = "性别 0 未知 1 男性 2 女性")
    private Integer gender;

    @NotBlank(message = "手机号不能为空")
    @NotNull(message = "手机号不能为空")
    @ApiModelProperty(value = "手机号")
    private String phoneNumber;

    @NotBlank(message = "微信号不能为空")
    @NotNull(message = "微信号不能为空")
    @ApiModelProperty(value = "微信号")
    private String wechatNumber;

    @NotBlank(message = "城市编码不能为空")
    @NotNull(message = "城市编码不能为空")
    @ApiModelProperty(value = "城市编码")
    private String cityAreaCode;

    @NotBlank(message = "地区码不能为空")
    @NotNull(message = "地区码不能为空")
    @ApiModelProperty(value = "地区码")
    private String areaCode;

    @NotBlank(message = "关于我不能为空")
    @NotNull(message = "关于我不能为空")
    @ApiModelProperty(value = "关于我")
    private String aboutMe;

    @NotNull(message = "CP身高最小值不能为空")
    @ApiModelProperty(value = "CP身高最小值")
    private Integer cpHeightMin;

    @NotNull(message = "CP身高最大值不能为空")
    @ApiModelProperty(value = "CP身高最大值")
    private Integer cpHeightMax;

    @NotNull(message = "CP体重最小值不能为空")
    @ApiModelProperty(value = "CP体重最小值")
    private Integer cpWeightMin;

    @NotNull(message = "CP体重最大值不能为空")
    @ApiModelProperty(value = "CP体重最大值")
    private Integer cpWeightMax;

    @NotNull(message = "CP学历最小值不能为空")
    @ApiModelProperty(value = "CP学历最小值")
    private Integer cpDegreeMin;

    @NotNull(message = "CP学历最大值不能为空")
    @ApiModelProperty(value = "CP学历最大值")
    private Integer cpDegreeMax;

    @NotNull(message = "CP出生年最小值不能为空")
    @ApiModelProperty(value = "CP出生年最小值")
    private String cpBirthYearMin;

    @NotNull(message = "CP出生年最大值不能为空")
    @ApiModelProperty(value = "CP出生年最大值")
    private String cpBirthYearMax;

    @NotNull(message = "CP星座不能为空")
    @ApiModelProperty(value = "CP星座")
    private Integer cpConstellation;

    @NotBlank(message = "CP一句话不能为空")
    @NotNull(message = "CP一句话不能为空")
    @ApiModelProperty(value = "CP一句话")
    private String cpContent;

    @ApiModelProperty(value = "用户ID")
    private Long userId;

}
