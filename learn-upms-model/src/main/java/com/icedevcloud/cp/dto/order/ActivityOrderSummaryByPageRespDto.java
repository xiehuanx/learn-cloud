package com.icedevcloud.cp.dto.order;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * author :xiehuan
 * Email: 1487471733@qq.com
 * Date: 2021/4/10
 * Describe:
 * @author xiehuan
 */
@Data
public class ActivityOrderSummaryByPageRespDto extends BaseRowModel implements Serializable {

    @ApiModelProperty(value = "活动编号")
    @ExcelProperty("活动编号")
    private String activityNo;

    @ApiModelProperty(value = "活动名称")
    @ExcelProperty("活动名称")
    private String activityName;

    @ApiModelProperty(value = "1-未开始；2-进行中；3-活动结束")
    @ExcelIgnore
    private Integer activityStatus;

    @ApiModelProperty(value = "1-未开始；2-进行中；3-活动结束")
    @ExcelProperty("活动状态")
    private String activityStatusStr;


    @ApiModelProperty(value = "参与总人数")
    @ExcelProperty("参与总人数")
    private Integer participation;

    @ApiModelProperty(value = "男生人数")
    @ExcelProperty("男生人数")
    private Integer boysNumber;

    @ApiModelProperty(value = "女生人数")
    @ExcelProperty("女生人数")
    private Integer girlsNumber;

    @ApiModelProperty(value = "cp对数")
    @ExcelProperty("cp对数")
    private Integer cpNumber;

    @ApiModelProperty(value = "缴费人数")
    @ExcelProperty("缴费人数")
    private Integer payNumber;

    @ApiModelProperty(value = "单价")
    @ExcelProperty("单价")
    private BigDecimal price;

    @ApiModelProperty(value = "缴费总金额")
    @ExcelProperty("缴费总金额")
    private BigDecimal payAmountSum;

    @ApiModelProperty(value = "退费总金额")
    @ExcelProperty("退费总金额")
    private BigDecimal refundAmountSum;

    @ApiModelProperty(value = "成本费用")
    @ExcelProperty("成本费用")
    private BigDecimal costFee;

    @ExcelProperty("实际活动金额")
    private BigDecimal realAmountSum;

    @ExcelProperty("实际收入")
    private BigDecimal realIncome;












}
