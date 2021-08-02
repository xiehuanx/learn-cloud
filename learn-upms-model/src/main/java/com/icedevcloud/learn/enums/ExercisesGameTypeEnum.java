package com.icedevcloud.learn.enums;

/**
 * author :xiehuan
 * Email: 1487471733@qq.com
 * Date: 2021/7/27
 * Describe:
 * @author xiehuan
 */
public enum ExercisesGameTypeEnum {
    /**
     * 选一选（一音频三个英文单词选一个正确的）
     */
    JUVENILE_1("juvenile", "选一选（一音频三个英文单词选一个正确的）", 1),
    /**
     * 选一选（一张图片三个英文单词选择一个正确的）
     */
    JUVENILE_2("juvenile", "选一选（一张图片三个英文单词选择一个正确的）", 2),
    /**
     * 找一找（一个英文单词根据三个图片点击正确的图）
     */
    JUVENILE_3("juvenile", "找一找（一个英文单词根据三个图片点击正确的图）", 3),
    /**
     * 找一找（一个英文音频三个图片点击播放后选择正确的图片）
     */
    JUVENILE_4("juvenile", "找一找（一个英文音频三个图片点击播放后选择正确的图片）", 4),
    /**
     * 单词和句子跟读（一个单词或一段句子录制3-6秒音频后自动播放）
     */
    JUVENILE_5("juvenile", "单词和句子跟读（一个单词或一段句子录制3-6秒音频后自动播放）", 5),

    /**
     * 拼句子（一段句子扣一个单词，选择正确的单词）
     */
    CHILD_1("child", "拼句子（一段句子扣一个单词，选择正确的单词）", 1),
    /**
     * 消消乐（四张中文牌四张英文牌，翻牌翻俩对应的成功消除）
     */
    CHILD_2("child", "消消乐（四张中文牌四张英文牌，翻牌翻俩对应的成功消除）", 2),
    /**
     * 单词和句子跟读（一个单词或一段句子录制3-6秒音频后自动播放）
     */
    CHILD_3("child", "单词和句子跟读（一个单词或一段句子录制3-6秒音频后自动播放）", 3)
    ;

    /**
     * 年龄类型
     */
    private String ageType;

    /**
     * 说明
     */
    private String explain;

    /**
     * 游戏类型
     */
    private Integer type;

    ExercisesGameTypeEnum(String ageType, String explain, Integer type) {
        this.ageType = ageType;
        this.explain = explain;
        this.type = type;
    }

    public String getAgeType() {
        return ageType;
    }

    public String getExplain() {
        return explain;
    }

    public Integer getType() {
        return type;
    }

    public String toString() {
        return "游戏类型:" + getType() + ", 年龄类型:" + getAgeType() + ", 说明:" + getExplain();
    }

}
