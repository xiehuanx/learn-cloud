package com.icedevcloud.learn.service.impl;

import com.icedevcloud.learn.entity.Question;
import com.icedevcloud.learn.mapper.QuestionMapper;
import com.icedevcloud.learn.service.IQuestionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author XiaoBingBy
 * @since 2021-07-24
 */
@Service
public class QuestionServiceImpl extends ServiceImpl<QuestionMapper, Question> implements IQuestionService {

    @Override
    public List<Object> getQuestionByTypeAndCurriculumId(Integer questionType, Long curriculumId) {
        return null;
    }
}
