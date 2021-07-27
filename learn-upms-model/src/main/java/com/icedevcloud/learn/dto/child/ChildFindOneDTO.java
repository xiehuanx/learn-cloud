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
 * 找一找（一个英文单词根据三个图片点击正确的图）
 */
@Data
public class ChildFindOneDTO implements Serializable {
    private static final long serialVersionUID = -1540632280175357925L;

    /**
     * 英文单词
     */
    @ApiModelProperty(value = "英文单词")
    private String word;

    /**
     * 正确的图片地址
     */
    @ApiModelProperty(value = "正确的图片地址")
    private String rightImageUrl;

    /**
     * 错误的图片地址
     */
    @ApiModelProperty(value = "错误的图片地址")
    private List<String> wrongImageUrl;

}
