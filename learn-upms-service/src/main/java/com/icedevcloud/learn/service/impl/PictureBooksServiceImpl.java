package com.icedevcloud.learn.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.icedevcloud.learn.dto.PictureBooksByPageRequest;
import com.icedevcloud.learn.entity.PictureBooks;
import com.icedevcloud.learn.mapper.PictureBooksMapper;
import com.icedevcloud.learn.service.IPictureBooksService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author XiaoBingBy
 * @since 2021-07-24
 */
@Service
public class PictureBooksServiceImpl extends ServiceImpl<PictureBooksMapper, PictureBooks> implements IPictureBooksService {

    @Override
    public IPage<PictureBooks> getPictureBooksByPage(PictureBooksByPageRequest pictureBooksByPageRequest) {
        Page<PictureBooks> page = new Page<PictureBooks>(pictureBooksByPageRequest.getCurrent(), pictureBooksByPageRequest.getPageSize());
        LambdaQueryWrapper<PictureBooks> pictureBooksLambdaQueryWrapper = Wrappers.<PictureBooks>lambdaQuery().eq(PictureBooks::getPictureBookType, pictureBooksByPageRequest.getPictureBookType());
        return this.page(page, pictureBooksLambdaQueryWrapper);
    }
}
