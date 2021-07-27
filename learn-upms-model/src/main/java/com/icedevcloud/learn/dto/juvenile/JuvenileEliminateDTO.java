package com.icedevcloud.learn.dto.juvenile;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * author :xiehuan
 * Email: 1487471733@qq.com
 * Date: 2021/7/27
 * Describe:
 * 消消乐（四张中文牌四张英文牌，翻牌翻俩对应的成功消除）
 */
@Data
public class JuvenileEliminateDTO implements Serializable {
    private static final long serialVersionUID = -4727751176338457455L;

    /**
     * 左边的牌单词集合
     */
    @ApiModelProperty(value = "左边的牌单词集合")
    private List<String> leftWords;

    /**
     * 右边的牌单词集合
     */
    @ApiModelProperty(value = "右边的牌单词集合")
    private List<String> rightWords;
}
