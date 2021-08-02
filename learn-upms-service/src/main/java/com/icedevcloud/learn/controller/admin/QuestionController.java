package com.icedevcloud.learn.controller.admin;


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



}
