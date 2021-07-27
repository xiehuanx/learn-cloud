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
 * 找一找（一个英文音频三个图片点击播放后选择正确的图片）
 */
@Data
public class ChildFindTwoDTO implements Serializable {
    private static final long serialVersionUID = 1216820030711198458L;

    /**
     * 英文单词
     */
    @ApiModelProperty(value = "英文单词")
    private String audioUrl;

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
