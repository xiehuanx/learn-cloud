package com.icedevcloud.learn.controller.admin;


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





}
