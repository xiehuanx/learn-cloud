package com.icedevcloud.common.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * <p>
 * 用户信息
 * </p>
 *
 * @author XiaoBingBy
 * @since 2021-04-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="WxUserInfo对象", description="用户信息")
public class WxUserInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "open_id")
    private String openId;

    @ApiModelProperty(value = "union_id")
    private String unionId;

    @ApiModelProperty(value = "用户昵称")
    private String nickName;

    @ApiModelProperty(value = "用户头像")
    private String avatarUrl;

    @ApiModelProperty(value = "用户所在国家")
    private String country;

    @ApiModelProperty(value = "用户所在城市")
    private String city;

    @ApiModelProperty(value = "用户所在省份")
    private String province;

    @ApiModelProperty(value = "显示 country，province，city 所用的语言")
    private String language;

    @ApiModelProperty(value = "身高")
    private Integer height;

    @ApiModelProperty(value = "体重")
    private Integer weight;

    @ApiModelProperty(value = "学历")
    private Integer degree;

    @ApiModelProperty(value = "出生年月")
    @JsonFormat(pattern = "yyyy-MM", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM")
    private Date birthDate;

    @ApiModelProperty(value = "星座")
    private Integer constellation;

    @ApiModelProperty(value = "用户性别 0 未知 1 男性 2 女性")
    private Integer gender;

    @ApiModelProperty(value = "用户绑定的手机号（国外手机号会有区号）")
    private String phoneNumber;

    @ApiModelProperty(value = "微信号")
    private String wechatNumber;

    @ApiModelProperty(value = "城市编码")
    private String cityAreaCode;

    @ApiModelProperty(value = "地区码")
    private String areaCode;

    @ApiModelProperty(value = "城市编码")
    @TableField(exist = false)
    private String cityAreaCodeStr;

    @ApiModelProperty(value = "地区码")
    @TableField(exist = false)
    private String areaCodeStr;

    @ApiModelProperty(value = "关于我")
    private String aboutMe;

    @ApiModelProperty(value = "CP身高最小值")
    private Integer cpHeightMin;

    @ApiModelProperty(value = "CP身高最大值")
    private Integer cpHeightMax;

    @ApiModelProperty(value = "CP体重最小值")
    private Integer cpWeightMin;

    @ApiModelProperty(value = "CP体重最大值")
    private Integer cpWeightMax;

    @ApiModelProperty(value = "CP学历最小值")
    private Integer cpDegreeMin;

    @ApiModelProperty(value = "CP学历最大值")
    private Integer cpDegreeMax;

    @ApiModelProperty(value = "CP出生年最小值")
    private String cpBirthYearMin;

    @ApiModelProperty(value = "CP出生年最大值")
    private String cpBirthYearMax;

    @ApiModelProperty(value = "CP星座")
    private Integer cpConstellation;

    @ApiModelProperty(value = "CP一句话")
    private String cpContent;

    @ApiModelProperty(value = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date gmtCreate;

    @ApiModelProperty(value = "更新时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date gmtModified;


}
