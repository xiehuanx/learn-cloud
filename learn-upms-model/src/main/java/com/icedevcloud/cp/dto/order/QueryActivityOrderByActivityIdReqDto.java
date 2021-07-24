package com.icedevcloud.cp.dto.order;

import lombok.Data;

import java.io.Serializable;

/**
 * author :xiehuan
 * Email: 1487471733@qq.com
 * Date: 2021/4/29
 * Describe:
 */
@Data
public class QueryActivityOrderByActivityIdReqDto implements Serializable {

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
         * 活动编号
         */
        private String activityNo;

    }
}
