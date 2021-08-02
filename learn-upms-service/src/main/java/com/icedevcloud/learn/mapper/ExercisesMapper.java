package com.icedevcloud.learn.mapper;

import com.icedevcloud.learn.IndexDataInfoDTO;
import com.icedevcloud.learn.dto.LearnExercisesLogDTO;
import com.icedevcloud.learn.entity.Exercises;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author XiaoBingBy
 * @since 2021-07-27
 */
public interface ExercisesMapper extends BaseMapper<Exercises> {
    /**
     * 通过class id，年龄类型，游戏类型，来获取对应的游戏
     * @param curriculumId class id
     * @param ageType 年龄类型
     * @param exerciseType 游戏类型
     * @return 完整的游戏与日志id
     */
    List<LearnExercisesLogDTO> selectExercisesLog(@Param("curriculumId") Long curriculumId, @Param("ageType") String ageType, @Param("exerciseType") Integer exerciseType, @Param("userId") Long userId);

    /**
     * 获取积分与天数
     * @param userId
     * @return
     */
    IndexDataInfoDTO getDays(@Param("userId") Long userId);

    /**
     * 分组统计每本书下有多少问题
     * @return
     */
    List<IndexDataInfoDTO> getSumGroupbyGrade();

    /**
     * 获取当前用户 做了这本书的多少习题
     * @param gradeId 书本id
     * @param userId 用户id
     * @return 题数量
     */
    Integer getCountLogByGradeIdAndUserId(@Param("gradeId") Long gradeId, @Param("userId") Long userId);
}
