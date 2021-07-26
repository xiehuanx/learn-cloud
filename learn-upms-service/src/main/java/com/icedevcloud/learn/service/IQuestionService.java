package com.icedevcloud.learn.service;

import com.icedevcloud.learn.entity.Question;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author XiaoBingBy
 * @since 2021-07-24
 */
public interface IQuestionService extends IService<Question> {
    /**
     * 通过类型和课节id，获取题
     * @param questionType 题类型
     * @param curriculumId 课节id
     * @return 题
     */
    List<Object> getQuestionByTypeAndCurriculumId(Integer questionType, Long curriculumId);
}
