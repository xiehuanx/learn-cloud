package com.icedevcloud.cp.dto.order;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * author :xiehuan
 * Email: 1487471733@qq.com
 * Date: 2021/4/19
 * Describe:
 */
@Data
public class ActivityInvitationPageRespDto implements Serializable {

    /**
     * 剩余可参加活动人数
     */
    private int remainingNumber;

    /**
     * 数据
     */
    private List<ActivityInvitationPageCpRespDto> activityInvitationPageCpRespDtos;

}
