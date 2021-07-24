package com.icedevcloud.cp.dto.order;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.Data;

import java.io.Serializable;

/**
 * author :xiehuan
 * Email: 1487471733@qq.com
 * Date: 2021/4/29
 * Describe:
 * @author xiehuan
 */
@Data
public class QueryActivityOrderByActivityIdDto extends BaseRowModel implements Serializable {

    @ExcelProperty("编号")
    private Long id;
    @ExcelProperty("昵称")
    private String nickName;

    @ExcelIgnore
    private String orderNo;

    @ExcelProperty("出生年月")
    private String birthDate;

    @ExcelIgnore
    private Integer degree;

    @ExcelProperty("学历")
    private String degreeStr;

    @ExcelIgnore
    private Integer gender;

    @ExcelProperty("性别")
    private String genderStr;

    @ExcelIgnore
    private String orderStatus;

    @ExcelIgnore
    private Long sloganId;


    @ExcelIgnore
    private Long orderNoBoyDefaultSlogan;


    @ExcelIgnore
    private Long orderNoGirlDefaultSlogan;

    @ExcelProperty("暗号")
    private String sloganContent;

}
