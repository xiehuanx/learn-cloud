package com.icedevcloud.learn.controller;


import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.icedevcloud.common.core.api.R;
import com.icedevcloud.learn.entity.Chapter;
import com.icedevcloud.learn.entity.Curriculum;
import com.icedevcloud.learn.service.ICurriculumService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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
@Api(value = "课程(课节)管理", tags = "课程(课节)管理", description = "课程(课节)管理")
@RestController
@RequestMapping("/learn/curriculum")
public class CurriculumController {

    @Autowired
    private ICurriculumService curriculumService;

    /**
     * 通过章节id，获取课节信息
     * @param chapterId 章节id
     * @return 课节数据
     */
    @ApiOperation(value = "获取课节信息", notes = "获取章节下的获取课节信息", produces = "application/json")
    @GetMapping("/getCurriculumByChapter/{chapterId}")
    public R<List<Curriculum>> getCurriculumByChapter(@PathVariable(value = "chapterId") Long chapterId) {
        return R.ok(curriculumService.list(Wrappers.<Curriculum>lambdaQuery().eq(Curriculum::getChapterId, chapterId)));
    }

}
