package com.icedevcloud.learn.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.icedevcloud.learn.dto.PictureBooksByPageRequest;
import com.icedevcloud.learn.entity.PictureBooks;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author XiaoBingBy
 * @since 2021-07-24
 */
public interface IPictureBooksService extends IService<PictureBooks> {

    /**
     * 获取分页信息
     * @param pictureBooksByPageRequest
     * @return
     */
    IPage<PictureBooks> getPictureBooksByPage(PictureBooksByPageRequest pictureBooksByPageRequest);
}
