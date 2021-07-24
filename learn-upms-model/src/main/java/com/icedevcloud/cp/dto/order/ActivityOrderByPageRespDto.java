package com.icedevcloud.cp.dto.order;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.icedevcloud.cp.entity.ActivityOrder;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * author :xiehuan
 * Email: 1487471733@qq.com
 * Date: 2021/4/7
 * Describe:
 */
@Data
public class ActivityOrderByPageRespDto extends ActivityOrder implements Serializable {

    @ApiModelProperty(value = "活动名称")
    private String activityName;

    @ApiModelProperty(value = "1-未开始；2-进行中；3-活动结束")
    private Integer activityStatus;

    @ApiModelProperty(value = "报名时间开始")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date signUpTimeStart;

    @ApiModelProperty(value = "报名时间结束")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date signUpTimeEnd;

    @ApiModelProperty(value = "活动价格")
    private BigDecimal price;

    @ApiModelProperty(value = "用户昵称")
    private String nickName;
}
