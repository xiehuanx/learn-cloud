package com.icedevcloud.cp.dto.order;

import com.icedevcloud.cp.entity.ActivityOrder;
import lombok.Data;

import java.io.Serializable;

/**
 * author :xiehuan
 * Email: 1487471733@qq.com
 * Date: 2021/4/20
 * Describe:
 */
@Data
public class ActivityOrderStatusRespDto implements Serializable {

    private Integer status;

    private ActivityOrder activityOrder;

}
