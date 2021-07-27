package com.icedevcloud.learn.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.sql.Blob;
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
 * @since 2021-07-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("learn_exercises")
@ApiModel(value="Exercises对象", description="")
public class Exercises implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "课程id")
    private Long curriculumId;

    @ApiModelProperty(value = "juvenile - 少儿；child-幼儿")
    private String ageType;

    @ApiModelProperty(value = "问题类型，")
    private Integer exerciseType;

    @ApiModelProperty(value = "练习题题目，可以是音频，可以是图片，可以是文字")
    private String exerciseTitle;

    @ApiModelProperty(value = "正确答案")
    private Blob correctAnswer;

    @ApiModelProperty(value = "错误答案")
    private Blob wrongAnswer;

    @ApiModelProperty(value = "创建时间")
    private Date gmtCreate;

    @ApiModelProperty(value = "更新时间")
    private Date gmtModified;


}
