package com.icedevcloud.common.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.icedevcloud.common.dto.BaseAreaCodeResDto;
import com.icedevcloud.common.dto.BaseAreaTreeResDto;
import com.icedevcloud.common.entity.BaseArea;

import java.util.List;

/**
 * <p>
 * 基础地区 服务类
 * </p>
 *
 * @author XiaoBingBy
 * @since 2021-04-11
 */
public interface IBaseAreaService extends IService<BaseArea> {

    /**
     * 查询所有基础地区信息
     *
     * @return
     */
    List<BaseAreaTreeResDto> queryAllBaseAreaTree();

    /**
     * 通过三级code 查询前2级code
     *
     * @param threeAreaCode
     * @return
     */
    BaseAreaCodeResDto threeAreaCodeByAreaCode(String threeAreaCode);

}
