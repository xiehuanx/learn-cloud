package com.icedevcloud.learn.dto.child;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * author :xiehuan
 * Email: 1487471733@qq.com
 * Date: 2021/7/27
 * Describe:
 */
@Data
public class ChildFollowDTO implements Serializable {
    private static final long serialVersionUID = 2801455212058100530L;
    /**
     * 跟读的单词或者句子
     */
    @ApiModelProperty(value = "跟读的单词或者句子")
    private String word;
}
