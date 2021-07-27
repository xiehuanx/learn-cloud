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
 * 选一选（一张图片三个英文单词选择一个正确的）
 */
@Data
public class ChildChooseTwoDTO implements Serializable {
    private static final long serialVersionUID = 7002179964426379298L;


    /**
     * 图片地址
     */
    @ApiModelProperty(value = "图片地址")
    private String imageUrl;

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
