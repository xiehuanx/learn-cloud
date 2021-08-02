package com.icedevcloud.learn.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * author :xiehuan
 * Email: 1487471733@qq.com
 * Date: 2021/8/2
 * Describe:
 */
@Data
public class PictureBooksByPageRequest implements Serializable {
    private static final long serialVersionUID = 5342592160889124050L;


    /**
     * 每页显示条数，默认 10
     */
    private long pageSize = 10;

    /**
     * 当前页
     */
    private long current = 1;


    private Integer pictureBookType;
}
