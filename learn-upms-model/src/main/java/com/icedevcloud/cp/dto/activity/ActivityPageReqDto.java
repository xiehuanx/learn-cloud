package com.icedevcloud.cp.dto.activity;

import lombok.Data;

import java.io.Serializable;

/**
 * author :xiehuan
 * Email: 1487471733@qq.com
 * Date: 2021/4/7
 * Describe:
 * @author xiehuan
 */
@Data
public class ActivityPageReqDto implements Serializable {


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
    public class QueryParam implements Serializable{
        /**
         * 活动名称
         */
        private String activityName;
        /**
         * 活动编号
         */
        private String activityNo;
        /**
         * 活动状态
         */
        private String activityStatus;
    }




}
