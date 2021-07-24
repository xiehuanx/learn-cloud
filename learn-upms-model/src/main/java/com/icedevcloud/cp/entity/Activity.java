package com.icedevcloud.cp.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;

import java.time.LocalDateTime;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.icedevcloud.common.mybatis.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * <p>
 * 活动管理表
 * </p>
 *
 * @author XiaoBingBy
 * @since 2021-03-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("cp_activity")
@ApiModel(value="Activity对象", description="活动管理表")
public class Activity implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    @JsonSerialize(using= ToStringSerializer.class)
    private Long id;

    @ApiModelProperty(value = "活动编号")
    private String activityNo;

    @ApiModelProperty(value = "活动名称")
    private String activityName;

    @ApiModelProperty(value = "累计匹配cp数量")
    private Integer cumulativeCpNumber;

    @ApiModelProperty(value = "报名时间开始")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date signUpTimeStart;

    @ApiModelProperty(value = "报名时间结束")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date signUpTimeEnd;

    @ApiModelProperty(value = "支付时间开始")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date payTimeStart;

    @ApiModelProperty(value = "支付时间介绍")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date payTimeEnd;

    @ApiModelProperty(value = "活动价格")
    private BigDecimal price;

    @ApiModelProperty(value = "城市编码")
    private String cityAreaCode;

    @ApiModelProperty(value = "地区码")
    private String areaCode;

    @ApiModelProperty(value = "cp对数")
    private Integer cpNumber;

    @ApiModelProperty(value = "成本费用")
    private BigDecimal costFee;

    @ApiModelProperty(value = "1-未开始；2-进行中；3-活动结束")
    private Integer activityStatus;

    @ApiModelProperty(value = "活动头图")
    private String activityLogoImg;

    @ApiModelProperty(value = "活动介绍")
    private String activityIntroduction;

    @ApiModelProperty(value = "活动地址")
    private String activityAddress;

    @ApiModelProperty(value = "历史活动图片")
    private String activityHistoryImg;

    @ApiModelProperty(value = "历史活动链接")
    private String activityHistoryUrl;

    @ApiModelProperty(value = "广告图片")
    private String activityAdImg;

    @ApiModelProperty(value = "广告链接")
    private String activityAdUrl;

    @ApiModelProperty(value = "活动联系人（微信）")
    private String activityWenchatContact;

    @ApiModelProperty(value = "男生身高最小值")
    private Integer boyHeightMin;

    @ApiModelProperty(value = "男生身高最大值")
    private Integer boyHeightMax;

    @ApiModelProperty(value = "男生体重最小值")
    private Integer boyWeightMin;

    @ApiModelProperty(value = "男生体重最大值")
    private Integer boyWeightMax;

    @ApiModelProperty(value = "男生学历最小值")
    private Integer boyDegreeMin;

    @ApiModelProperty(value = "男生学历最大值")
    private Integer boyDegreeMax;

    @ApiModelProperty(value = "男生出生年最小值")
    private String boyBirthYearMin;

    @ApiModelProperty(value = "男生出生年最大值")
    private String boyBirthYearMax;

    @ApiModelProperty(value = "女生身高最小值")
    private Integer girlHeightMin;

    @ApiModelProperty(value = "女生身高最大值")
    private Integer girlHeightMax;

    @ApiModelProperty(value = "女生体重最小值")
    private Integer girlWeightMin;

    @ApiModelProperty(value = "女生体重最大值")
    private Integer girlWeightMax;

    @ApiModelProperty(value = "女生学历最小值")
    private Integer girlDegreeMin;

    @ApiModelProperty(value = "女生学历最大值")
    private Integer girlDegreeMax;

    @ApiModelProperty(value = "女生出生年最小值")
    private String girlBirthYearMin;

    @ApiModelProperty(value = "女生出生年最大值")
    private String girlBirthYearMax;

    @ApiModelProperty(value = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date gmtCreate;

    @ApiModelProperty(value = "更新时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date gmtModified;


}
