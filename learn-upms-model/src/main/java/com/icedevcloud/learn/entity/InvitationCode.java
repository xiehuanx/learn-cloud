package com.icedevcloud.learn.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
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
 * @since 2021-07-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="InvitationCode对象", description="")
public class InvitationCode implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableField("Invitation_code")
    private String invitationCode;


}
