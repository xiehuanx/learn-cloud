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
    /**
     * 幼儿游戏：
     * 1.选一选（一音频三个英文单词选一个正确的）
     * 2.选一选（一张图片三个英文单词选择一个正确的）
     * 3.找一找（一个英文单词根据三个图片点击正确的图）
     * 4.找一找（一个英文音频三个图片点击播放后选择正确的图片）
     * 5.单词和句子跟读（一个单词或一段句子录制3-6秒音频后自动播放）
     *
     * 少儿游戏：
     * 1.拼句子（一段句子扣一个单词，选择正确的单词）
     * 2.消消乐（四张中文牌四张英文牌，翻牌翻俩对应的成功消除）
     * 3.单词和句子跟读（一个单词或一段句子录制3-6秒音频后自动播放）
     */
    private Integer exerciseType;

    @ApiModelProperty(value = "练习题题目，可以是音频，可以是图片，可以是文字")
    private String exerciseTitle;

    @ApiModelProperty(value = "正确答案")
    private String correctAnswer;

    @ApiModelProperty(value = "错误答案")
    private String wrongAnswer;

    @ApiModelProperty(value = "创建时间")
    private Date gmtCreate;

    @ApiModelProperty(value = "更新时间")
    private Date gmtModified;


}
