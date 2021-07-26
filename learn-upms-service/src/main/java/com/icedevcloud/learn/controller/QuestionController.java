package com.icedevcloud.learn.controller;


import com.icedevcloud.common.core.api.R;
import com.icedevcloud.learn.entity.Question;
import com.icedevcloud.learn.service.IQuestionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author XiaoBingBy
 * @since 2021-07-24
 */
@Api(value = "练习题管理接口类", tags = "练习题管理", description = "练习题管理")
@RestController
@RequestMapping("/learn/question")
public class QuestionController {

    @Autowired
    private IQuestionService questionService;

    /**
     * 获取课后练习题
     * @param questionType 练习题类型
     * @param curriculumId 课节id
     * @return 练习题信息
     */
    @ApiOperation(value = "获取练习题", notes = "获取课节下的练习题管理信息", produces = "application/json")
    @PostMapping("/getQuestionByTypeAndCurriculumId")
    public R<List<Object>> getQuestionByTypeAndCurriculumId(@RequestParam("questionType") Integer questionType, @RequestParam("curriculumId") Long curriculumId) {
        return R.ok(questionService.getQuestionByTypeAndCurriculumId(questionType, curriculumId));
    }

}
