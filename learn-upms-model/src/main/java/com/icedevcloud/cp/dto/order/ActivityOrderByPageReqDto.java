package com.icedevcloud.cp.dto.order;

import com.icedevcloud.cp.dto.activity.ActivityPageReqDto;
import lombok.Data;

import java.io.Serializable;

/**
 * author :xiehuan
 * Email: 1487471733@qq.com
 * Date: 2021/4/7
 * Describe:
 */
@Data
public class ActivityOrderByPageReqDto implements Serializable {

    /**
     * 每页显示条数，默认 10
     */
    private long pageSize = 10;

    /**
     * 当前页
     */
    private long current = 1;

    private QueryParam queryParam;



    @Data
    public static class QueryParam implements Serializable{
        /**
         * 活动名称
         */
        private String activityNo;
        /**
         * 手机号码
         */
        private String phoneNumber;
        /**
         * 活动状态
         */
        private String activityStatus;
        /**
         * 性别
         */
        private String gender;
        /**
         * 订单状态
         */
        private String orderStatus;
    }
}
