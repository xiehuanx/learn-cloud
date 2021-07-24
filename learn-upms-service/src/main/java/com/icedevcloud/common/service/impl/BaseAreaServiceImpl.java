package com.icedevcloud.common.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.icedevcloud.common.core.exception.ApiException;
import com.icedevcloud.common.dto.BaseAreaCodeResDto;
import com.icedevcloud.common.dto.BaseAreaTreeResDto;
import com.icedevcloud.common.entity.BaseArea;
import com.icedevcloud.common.mapper.BaseAreaMapper;
import com.icedevcloud.common.service.IBaseAreaService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 基础地区 服务实现类
 * </p>
 *
 * @author XiaoBingBy
 * @since 2021-04-11
 */
@Service
public class BaseAreaServiceImpl extends ServiceImpl<BaseAreaMapper, BaseArea> implements IBaseAreaService {

    @Override
    public List<BaseAreaTreeResDto> queryAllBaseAreaTree() {
        List<BaseArea> baseAreaList = this.list(
                Wrappers.<BaseArea>lambdaQuery()
                .orderByAsc(BaseArea::getAreaCode)
        );
        // 一级
        List<BaseAreaTreeResDto> oneBaseAreaTreeResDto = baseAreaList.stream().filter(item -> {
            return "1".equals(item.getAreaType());
        }).map(item -> {
            BaseAreaTreeResDto baseAreaTreeResDto = new BaseAreaTreeResDto();
            BeanUtils.copyProperties(item, baseAreaTreeResDto);
            return baseAreaTreeResDto;
        }).collect(Collectors.toList());

        // 二级
        for (BaseAreaTreeResDto item2 : oneBaseAreaTreeResDto) {
            List<BaseAreaTreeResDto> tempBaseAreaTreeTwo = baseAreaList.stream().filter(temp -> {
                return "2".equals(temp.getAreaType()) && item2.getAreaCode().equals(temp.getParentAreaCode());
            }).map(temp -> {
                BaseAreaTreeResDto baseAreaTreeResDto = new BaseAreaTreeResDto();
                BeanUtils.copyProperties(temp, baseAreaTreeResDto);
                return baseAreaTreeResDto;
            }).collect(Collectors.toList());
            item2.setChildren(tempBaseAreaTreeTwo);
            // 三级
            for (BaseAreaTreeResDto item3 : tempBaseAreaTreeTwo) {
                List<BaseAreaTreeResDto> tempBaseAreaTreeThree = baseAreaList.stream().filter(temp -> {
                    return "3".equals(temp.getAreaType()) && item3.getAreaCode().equals(temp.getParentAreaCode());
                }).map(temp -> {
                    BaseAreaTreeResDto baseAreaTreeResDto = new BaseAreaTreeResDto();
                    BeanUtils.copyProperties(temp, baseAreaTreeResDto);
                    return baseAreaTreeResDto;
                }).collect(Collectors.toList());
                item3.setChildren(tempBaseAreaTreeThree);
            }
        }

        return oneBaseAreaTreeResDto;
    }

    @Override
    public BaseAreaCodeResDto threeAreaCodeByAreaCode(String threeAreaCode) {
        BaseArea threeAreaCodeData = this.getOne(Wrappers.<BaseArea>lambdaQuery()
                .eq(BaseArea::getAreaCode, threeAreaCode)
                .eq(BaseArea::getAreaType, "3")
        );
        if (threeAreaCodeData == null) {
            new ApiException("数据不存在");
        }

        BaseArea twoAreaCodeData = this.getOne(Wrappers.<BaseArea>lambdaQuery()
                .eq(BaseArea::getAreaCode, threeAreaCodeData.getParentAreaCode())
                .eq(BaseArea::getAreaType, "2")
        );
        if (twoAreaCodeData == null) {
            new ApiException("数据不存在");
        }

        BaseArea oneAreaCodeData = this.getOne(Wrappers.<BaseArea>lambdaQuery()
                .eq(BaseArea::getAreaCode, twoAreaCodeData.getParentAreaCode())
                .eq(BaseArea::getAreaType, "1")
        );
        if (oneAreaCodeData == null) {
            new ApiException("数据不存在");
        }

        BaseAreaCodeResDto baseAreaCodeResDto = new BaseAreaCodeResDto();
        baseAreaCodeResDto.setOneAreaCode(oneAreaCodeData.getAreaCode());
        baseAreaCodeResDto.setTwoAreaCode(twoAreaCodeData.getAreaCode());
        baseAreaCodeResDto.setThreeAreaCode(threeAreaCodeData.getAreaCode());
        return baseAreaCodeResDto;
    }

}
