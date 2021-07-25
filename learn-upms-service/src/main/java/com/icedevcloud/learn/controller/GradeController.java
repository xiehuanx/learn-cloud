package com.icedevcloud.learn.controller;


import com.icedevcloud.common.core.api.R;
import com.icedevcloud.learn.entity.Grade;
import com.icedevcloud.learn.service.IGradeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
@Api(value = "年级管理", tags = "年级管理", description = "年级管理")
@RestController
@RequestMapping("/learn/grade")
public class GradeController {

    @Autowired
    private IGradeService gradeService;

    @ApiOperation(value = "获取所有年级信息", notes = "获取所有年级信息接口", produces = "application/json")
    @GetMapping("/all")
    public R<List<Grade>> getAllGrade() {
        return R.ok(gradeService.list());
    }
}
