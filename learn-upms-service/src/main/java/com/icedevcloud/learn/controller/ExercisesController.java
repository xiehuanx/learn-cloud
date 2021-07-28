package com.icedevcloud.learn.controller;


import com.icedevcloud.common.core.api.R;
import com.icedevcloud.learn.service.IExercisesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author XiaoBingBy
 * @since 2021-07-27
 */
@Api(value = "游戏管理", tags = "游戏管理", description = "游戏管理")
@RestController
@RequestMapping("/learn/exercises")
public class ExercisesController {

    @Autowired
    private IExercisesService exercisesService;

    @ApiOperation(value = "获取游戏信息", notes = "获取游戏信息接口", produces = "application/json")
    @PostMapping("/getExercises")
    public <T> R<T> getExercises(@RequestParam("curriculumId") Integer curriculumId,
                              @RequestParam("exerciseType") Integer exerciseType,
                              @RequestParam("ageType") String ageType) {
        return R.ok(exercisesService.getExercises(curriculumId, exerciseType, ageType));
    }

}
