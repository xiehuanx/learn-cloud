package com.icedevcloud.common.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.icedevcloud.common.entity.WxUserInfo;
import com.icedevcloud.cp.dto.order.WxUserInfoPageRespDto;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author XiaoBingBy
 * @since 2020-09-29
 */
public interface WxUserInfoMapper extends BaseMapper<WxUserInfo> {

}
