package com.icedevcloud.learn.enums;

/**
 * author :xiehuan
 * Email: 1487471733@qq.com
 * Date: 2021/7/27
 * Describe:
 * @author xiehuan
 * 对于年龄段的枚举类
 */
public enum ExercisesAgeEnum {
    /**
     * 少儿
     */
    JUVENILE("juvenile", "少儿"),
    /**
     * 幼儿
     */
    CHILD("child", "幼儿");

    /**
     * 类型
     */
    private String type;

    /**
     * 类型对应的名称
     */
    private String name;

    ExercisesAgeEnum(String type, String name){
        this. name = name;
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }
}
