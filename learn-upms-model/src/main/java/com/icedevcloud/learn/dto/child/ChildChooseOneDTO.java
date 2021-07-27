package com.icedevcloud.learn.dto.child;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * author :xiehuan
 * Email: 1487471733@qq.com
 * Date: 2021/7/27
 * Describe:
 * 1.选一选（一音频三个英文单词选一个正确的）
 */
@Data
public class ChildChooseOneDTO implements Serializable {
    private static final long serialVersionUID = 1913729649590117312L;

    /**
     * 音频地址
     */
    @ApiModelProperty(value = "音频地址")
    private String audioUrl;

    /**
     * 正确的单词或者句子
     */
    @ApiModelProperty(value = "正确的单词或者句子")
    private String rightWord;

    /**
     * 错误的单词或者句子集合
     */
    @ApiModelProperty(value = "错误的单词或者句子集合")
    private List<String> wrongWord;

}
