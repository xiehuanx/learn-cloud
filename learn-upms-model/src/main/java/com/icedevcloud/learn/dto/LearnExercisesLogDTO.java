package com.icedevcloud.learn.dto;

import com.icedevcloud.learn.entity.Exercises;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * author :xiehuan
 * Email: 1487471733@qq.com
 * Date: 2021/8/2
 * Describe:
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class LearnExercisesLogDTO extends Exercises {


    private static final long serialVersionUID = 4856803710302819062L;
    @ApiModelProperty(value = "标志位，如果logId不为null，说明了这个游戏中的题 玩家做过，")
    private Integer logId;


}
