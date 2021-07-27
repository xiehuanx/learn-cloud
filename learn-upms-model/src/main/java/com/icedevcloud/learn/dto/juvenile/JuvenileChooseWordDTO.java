package com.icedevcloud.learn.dto.juvenile;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * author :xiehuan
 * Email: 1487471733@qq.com
 * Date: 2021/7/26
 * Describe:
 * 拼句子（一段句子扣一个单词，选择正确的单词）
 * @author xiehuan
 */
@Data
public class JuvenileChooseWordDTO implements Serializable {


    private static final long serialVersionUID = -4786849414390003402L;

    /**
     * 句子
     */
    @ApiModelProperty(value = "句子")
    private String comments;

    /**
     * 正确的单词
     */
    @ApiModelProperty(value = "正确的单词")
    private String rightWord;

    /**
     * 错误的单词集合
     */
    @ApiModelProperty(value = "错误的单词集合")
    private List<String> wrongWord;
}
