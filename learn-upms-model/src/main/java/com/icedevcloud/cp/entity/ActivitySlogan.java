package com.icedevcloud.cp.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.icedevcloud.common.mybatis.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 暗号活动订单关联表s
 * </p>
 *
 * @author XiaoBingBy
 * @since 2021-03-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("cp_activity_slogan")
@ApiModel(value="ActivitySlogan对象", description="暗号活动订单关联表s")
public class ActivitySlogan extends BaseEntity {

    private static final long serialVersionUID = 1L;


    @ApiModelProperty(value = "暗号id")
    @JsonSerialize(using= ToStringSerializer.class)
    private Long sloganId;

    @ApiModelProperty(value = "活动id")
    @JsonSerialize(using= ToStringSerializer.class)
    private Long activityId;

    @ApiModelProperty(value = "订单号男")
    private String orderNoBoy;

    @ApiModelProperty(value = "订单号女")
    private String orderNoGirl;

    @JsonSerialize(using= ToStringSerializer.class)
    private Long orderNoBoyDefaultSlogan;

    @JsonSerialize(using= ToStringSerializer.class)
    private Long orderNoGirlDefaultSlogan;

}
