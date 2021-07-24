package com.icedevcloud.cp.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
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
 * 活动订单表
 * </p>
 *
 * @author XiaoBingBy
 * @since 2021-03-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("cp_activity_order")
@ApiModel(value="ActivityOrder对象", description="活动订单表")
public class ActivityOrder {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    @JsonSerialize(using= ToStringSerializer.class)
    private Long id;

    @ApiModelProperty(value = "订单号")
    private String orderNo;

    @ApiModelProperty(value = "活动编号")
    private String activityNo;

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

    @ApiModelProperty(value = "总金额")
    private BigDecimal totalAmount;

    @ApiModelProperty(value = "支付金额")
    private BigDecimal paymentAmount;

    @ApiModelProperty(value = "订单状态")
    private String orderStatus;

    @ApiModelProperty(value = "支付订单号")
    private String payNo;

    @ApiModelProperty(value = "退款时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date paymentTime;

    @ApiModelProperty(value = "退款金额")
    private BigDecimal refundAmount;

    @ApiModelProperty(value = "支付时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date refundTime;

    @ApiModelProperty(value = "用户ID")
    private Long userId;

    @ApiModelProperty(value = "CP用户ID")
    private Long cpUserId;

    @ApiModelProperty(value = "号码")
    private Integer userNumber;

    @ApiModelProperty(value = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date gmtCreate;

    @ApiModelProperty(value = "更新时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date gmtModified;

}
