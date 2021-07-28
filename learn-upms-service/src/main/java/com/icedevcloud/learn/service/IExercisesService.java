package com.icedevcloud.learn.service;

import com.icedevcloud.learn.dto.child.ChildChooseOneDTO;
import com.icedevcloud.learn.dto.child.ChildChooseTwoDTO;
import com.icedevcloud.learn.dto.child.ChildFindOneDTO;
import com.icedevcloud.learn.entity.Exercises;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author XiaoBingBy
 * @since 2021-07-27
 */
public interface IExercisesService extends IService<Exercises> {

    /**
     * 泛型方法，游戏数据获取
     * @param curriculumId 课节id
     * @param exerciseType 游戏类型
     * @param <T> 泛型数据
     * @return 游戏数据
     */
    <T> T getExercises(Integer curriculumId, Integer exerciseType, String ageType);

}
