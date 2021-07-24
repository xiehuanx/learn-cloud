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

    IPage<WxUserInfo> userInfoPage(Page<WxUserInfo> wxUserInfoPageRespDtoPage, @Param("nickName") String nickName,
                                   @Param("phoneNumber")String phoneNumber, @Param("birthDateStartStr") String birthDateStartStr,
                                   @Param("birthDateEndStr") String birthDateEndStr, @Param("degreeMin") Integer degreeMin,
                                   @Param("degreeMax") Integer degreeMax, @Param("cityAreaCode") String cityAreaCode,
                                   @Param("areaCode") String areaCode, @Param("gender") Integer gender);

}
