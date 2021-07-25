package com.icedevcloud.learn.controller;


import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.icedevcloud.common.core.api.R;
import com.icedevcloud.learn.entity.Chapter;
import com.icedevcloud.learn.service.IChapterService;
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
@Api(value = "章节管理接口类", tags = "章节管理", description = "章节管理")
@RestController
@RequestMapping("/learn/chapter")
public class ChapterController {

    @Autowired
    private IChapterService chapterService;

    /**
     * 通过年级id，获取章节信息
     * @param gradeId 年级id
     * @return 章节数据
     */
    @ApiOperation(value = "获取章节信息", notes = "获取年级下的章节信息", produces = "application/json")
    @GetMapping("/getChapterByGrade/{gradeId}")
    public R<List<Chapter>> getChapterByGrade(@PathVariable(value = "gradeId") Long gradeId) {
        return R.ok(chapterService.list(Wrappers.<Chapter>lambdaQuery().eq(Chapter::getGradeId, gradeId)));
    }


}
