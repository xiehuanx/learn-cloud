package com.icedevcloud.learn.dto.juvenile;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * author :xiehuan
 * Email: 1487471733@qq.com
 * Date: 2021/7/26
 * Describe:
 * @author xiehuan
 */
@Data
public class JuvenileFellowDTO implements Serializable {
    private static final long serialVersionUID = 3286610209572263042L;

    /**
     * 跟读的单词或者句子
     */
    @ApiModelProperty(value = "跟读的单词或者句子")
    private String word;
}
