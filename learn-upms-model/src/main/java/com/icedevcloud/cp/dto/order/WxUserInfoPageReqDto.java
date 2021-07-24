package com.icedevcloud.cp.dto.order;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.icedevcloud.cp.dto.activity.ActivityPageReqDto;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * author :xiehuan
 * Email: 1487471733@qq.com
 * Date: 2021/4/12
 * Describe:
 */
@Data
public class WxUserInfoPageReqDto implements Serializable {

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

        @ApiModelProperty(value = "用户昵称")
        private String nickName;

        @ApiModelProperty(value = "用户绑定的手机号（国外手机号会有区号）")
        private String phoneNumber;


        @ApiModelProperty(value = "出生年月开始")
        private String birthDateStartStr;

        @ApiModelProperty(value = "出生年月结束")
        private String birthDateEndStr;

        @ApiModelProperty(value = "CP学历最小值")
        private Integer degreeMin;

        @ApiModelProperty(value = "CP学历最大值")
        private Integer degreeMax;


        @ApiModelProperty(value = "城市编码")
        private String cityAreaCode;


        @ApiModelProperty(value = "地区码")
        private String areaCode;

        @ApiModelProperty(value = "性别 0 未知 1 男性 2 女性")
        private Integer gender;

    }
}
