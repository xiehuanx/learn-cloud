package com.icedevcloud.cp.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

import com.icedevcloud.common.mybatis.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author XiaoBingBy
 * @since 2021-03-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("cp_slogan")
@ApiModel(value="Slogan对象", description="")
public class Slogan extends BaseEntity {

    private static final long serialVersionUID = 1L;


    @ApiModelProperty(value = "内容")
    private String sloganContent;

    @ApiModelProperty(value = "状态 1-已启用；2-已停用")
    private Integer sloganStatus;

    private Integer sloganDefault;


}
