package com.icedevcloud.learn.service;

import com.icedevcloud.learn.IndexDataInfoDTO;
import com.icedevcloud.learn.entity.Exercises;
import com.baomidou.mybatisplus.extension.service.IService;

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
    <T> T getExercises(Long curriculumId, Integer exerciseType, String ageType);

    /**
     * 获取用户的进度，积分，天数
     * @return dto数据
     */
    IndexDataInfoDTO getIndexDataInfo(Long gradeId);

}
