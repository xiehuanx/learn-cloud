package com.icedevcloud.learn.controller.api;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.icedevcloud.common.core.api.R;
import com.icedevcloud.common.service.ITokenManager;
import com.icedevcloud.learn.IndexDataInfoDTO;
import com.icedevcloud.learn.dto.PictureBooksByPageRequest;
import com.icedevcloud.learn.entity.Chapter;
import com.icedevcloud.learn.entity.Curriculum;
import com.icedevcloud.learn.entity.Grade;
import com.icedevcloud.learn.entity.IntegralLog;
import com.icedevcloud.learn.entity.PictureBooks;
import com.icedevcloud.learn.enums.ExercisesGameTypeEnum;
import com.icedevcloud.learn.service.IChapterService;
import com.icedevcloud.learn.service.ICurriculumService;
import com.icedevcloud.learn.service.IExercisesService;
import com.icedevcloud.learn.service.IGradeService;
import com.icedevcloud.learn.service.IIntegralLogService;
import com.icedevcloud.learn.service.IPictureBooksService;
import com.icedevcloud.learn.service.IQuestionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * author :xiehuan
 * Email: 1487471733@qq.com
 * Date: 2021/8/2
 * Describe:
 */
@Api(value = "对外开发API", tags = "小程序API接口", description = "章节管理")
@RestController
@RequestMapping("/learn/api")
public class LeanWordApiController {

    @Autowired
    private IChapterService chapterService;

    @Autowired
    private ICurriculumService curriculumService;

    @Autowired
    private IExercisesService exercisesService;


    @Autowired
    private IGradeService gradeService;

    @Autowired
    private IIntegralLogService integralLogService;

    @Autowired
    private ITokenManager iTokenManager;

    @Autowired
    private IQuestionService questionService;

    @Autowired
    private IPictureBooksService pictureBooksService;

    /**
     * 通过年级id，获取章节信息
     *
     * @param gradeId 年级id
     * @return 章节数据
     */
    @ApiOperation(value = "获取unit", notes = "获取年级下的章节信息", produces = "application/json")
    @GetMapping("/getChapterByGrade/{gradeId}")
    public R<List<Chapter>> getChapterByGrade(@PathVariable(value = "gradeId") Long gradeId) {
        return R.ok(chapterService.list(Wrappers.<Chapter>lambdaQuery().eq(Chapter::getGradeId, gradeId)));
    }

    /**
     * 通过章节id，获取课节信息
     *
     * @param chapterId 章节id
     * @return 课节数据
     */
    @ApiOperation(value = "获取class", notes = "获取章节下的获取课节信息", produces = "application/json")
    @GetMapping("/getCurriculumByChapter/{chapterId}")
    public R<List<Curriculum>> getCurriculumByChapter(@PathVariable(value = "chapterId") Long chapterId) {
        return R.ok(curriculumService.list(Wrappers.<Curriculum>lambdaQuery().eq(Curriculum::getChapterId, chapterId)));
    }

    @ApiOperation(value = "获取class下游戏信息", notes = "获取游戏信息接口", produces = "application/json")
    @PostMapping("/getExercises")
    public <T> R<T> getExercises(@RequestParam("curriculumId") Long curriculumId,
                                 @RequestParam("exerciseType") Integer exerciseType,
                                 @RequestParam("ageType") String ageType) {
        return R.ok(exercisesService.getExercises(curriculumId, exerciseType, ageType));
    }

    @ApiOperation(value = "获取ageType与exerciseType信息", notes = "获取ageType与exerciseType信息", produces = "application/json")
    @GetMapping("/exercisesGameTypeEnum")
    public R<List<String>> getExercisesGameTypeEnum(){
        List<String> strings = new ArrayList<>();
        for (ExercisesGameTypeEnum exercisesGameTypeEnum : ExercisesGameTypeEnum.values()) {
            strings.add(exercisesGameTypeEnum.toString());
        }
        return R.ok(strings);
    }


    @ApiOperation(value = "获取课本信息", notes = "获取所有年级信息接口", produces = "application/json")
    @GetMapping("/allBooks")
    public R<List<Grade>> getAllGrade() {
        return R.ok(gradeService.list());
    }


    /**
     * 小朋友答题后，登记做题结果，答对计1分，答错不计分
     *
     * @param integralLog 日志
     * @return 是否成功
     */
    @ApiOperation(value = "答题登记积分", notes = "答题登记积分接口", produces = "application/json")
    @PostMapping("/save")
    public R<Boolean> saveUserIntergralLog(@RequestBody IntegralLog integralLog) {
        Long userId = iTokenManager.getCurrentUserInfo().getId();
        integralLog.setUserId(userId);
        return R.ok(integralLogService.save(integralLog));
    }


    /**
     * 获取课后练习题
     *
     * @param questionType 练习题类型
     * @param curriculumId 课节id
     * @return 练习题信息
     */
    @ApiOperation(value = "获取练习题", notes = "获取课节下的练习题管理信息", produces = "application/json")
    @PostMapping("/getQuestionByTypeAndCurriculumId")
    public R<List<Object>> getQuestionByTypeAndCurriculumId(@RequestParam("questionType") Integer questionType, @RequestParam("curriculumId") Long curriculumId) {
        return R.ok(questionService.getQuestionByTypeAndCurriculumId(questionType, curriculumId));
    }


    @PostMapping("/IndexDataInfo")
    @ApiOperation(value = "首页积分进度与天数", notes = "获取课节下的练习题管理信息", produces = "application/json")
    public R<IndexDataInfoDTO> getIndexDataInfo(@RequestParam(value = "gradeId") Long gradeId) {
        return R.ok(exercisesService.getIndexDataInfo(gradeId));
    }

    @PostMapping("/getPictureBooksByPage")
    @ApiOperation(value = "绘本分页", notes = "绘本分页", produces = "application/json")
    public R<IPage<PictureBooks>> getPictureBooksByPage(@RequestBody PictureBooksByPageRequest pictureBooksByPageRequest) {
        return R.ok(pictureBooksService.getPictureBooksByPage(pictureBooksByPageRequest));
    }


}
