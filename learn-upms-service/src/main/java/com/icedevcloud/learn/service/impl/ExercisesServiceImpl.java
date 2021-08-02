package com.icedevcloud.learn.service.impl;

import com.icedevcloud.common.service.ITokenManager;
import com.icedevcloud.learn.IndexDataInfoDTO;
import com.icedevcloud.learn.dto.LearnExercisesLogDTO;
import com.icedevcloud.learn.dto.child.ChildChooseOneDTO;
import com.icedevcloud.learn.dto.child.ChildChooseTwoDTO;
import com.icedevcloud.learn.dto.child.ChildFindOneDTO;
import com.icedevcloud.learn.dto.child.ChildFindTwoDTO;
import com.icedevcloud.learn.dto.child.ChildFollowDTO;
import com.icedevcloud.learn.dto.juvenile.JuvenileChooseWordDTO;
import com.icedevcloud.learn.dto.juvenile.JuvenileEliminateDTO;
import com.icedevcloud.learn.dto.juvenile.JuvenileFellowDTO;
import com.icedevcloud.learn.entity.Exercises;
import com.icedevcloud.learn.mapper.ExercisesMapper;
import com.icedevcloud.learn.service.IExercisesService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author XiaoBingBy
 * @since 2021-07-27
 */
@Service
public class ExercisesServiceImpl extends ServiceImpl<ExercisesMapper, Exercises> implements IExercisesService {

    @Autowired
    private ExercisesMapper exercisesMapper;

    @Autowired
    private ITokenManager iTokenManager;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public static Map<Integer, Integer> sumGroupbyGradeMap = new HashMap<>();

    @Override
    public <T> T getExercises(Long curriculumId, Integer exerciseType, String ageType) {
        List<LearnExercisesLogDTO> exercisesList = exercisesMapper.selectExercisesLog(curriculumId, ageType, exerciseType, iTokenManager.getCurrentUserInfo().getId());
        Assert.isNull(exercisesList, "数据为空，请录入数据");
        return getList(exerciseType, ageType, exercisesList);
    }

    @Override
    public IndexDataInfoDTO getIndexDataInfo(Long gradeId) {
        //获取天数
        IndexDataInfoDTO indexDataInfoDTO = exercisesMapper.getDays(iTokenManager.getCurrentUserInfo().getId());
        //获取到的这本书的题总数
        Integer integer = sumGroupbyGradeMap.get(gradeId.intValue());
        // 这个用户做了多少道题
        Integer countLogByGradeIdAndUserId = exercisesMapper.getCountLogByGradeIdAndUserId(gradeId, iTokenManager.getCurrentUserInfo().getId());
        if (countLogByGradeIdAndUserId == 0) {
            indexDataInfoDTO.setSpeed("0");
        } else {
            double doubleValue = BigDecimal.valueOf(countLogByGradeIdAndUserId).divide(BigDecimal.valueOf(integer), 2, RoundingMode.HALF_UP).doubleValue();
            indexDataInfoDTO.setSpeed(String.valueOf(doubleValue));
        }
        return indexDataInfoDTO;
    }

    private <T> T getList(Integer exerciseType, String ageType, List<LearnExercisesLogDTO> exercisesList) {
        switch (ageType) {
            case "child":
                return getListByExerciseTypeForChild(exerciseType, exercisesList);
            case "juvenile":
                return getListByExerciseTypeForJuvenile(exerciseType, exercisesList);
            default:
                throw new NullPointerException("非法的ageType参数");
        }
    }

    /**
     * 返回幼儿游戏数据
     *
     * @param exerciseType  游戏类型
     * @param exercisesList 输入数据
     * @param <T>           返回数据
     */
    public <T> T getListByExerciseTypeForChild(Integer exerciseType, List<LearnExercisesLogDTO> exercisesList) {
        switch (exerciseType) {
            case 1:
                return getListByExerciseTypeForChildChooseOne(exercisesList);
            case 2:
                return getListByExerciseTypeForChildChooseTwo(exercisesList);
            case 3:
                return getListByExerciseTypeForChildFindOne(exercisesList);
            case 4:
                return getListByExerciseTypeForChildFindTwo(exercisesList);
            case 5:
                return getListByExerciseTypeForChildFollow(exercisesList);
            default:
                throw new NullPointerException("非法的exerciseType参数");
        }
    }

    /**
     * 幼儿选一选一
     *
     * @param exercisesList 原始数据
     * @param <T>           需要返回的数据
     * @return 重新映射后的数据
     */
    public <T> T getListByExerciseTypeForChildChooseOne(List<LearnExercisesLogDTO> exercisesList) {
        List<ChildChooseOneDTO> childChooseOneDTOList = new ArrayList<>();
        for (LearnExercisesLogDTO exercises : exercisesList) {
            ChildChooseOneDTO childChooseOneDTO = new ChildChooseOneDTO();
            childChooseOneDTO.setAudioUrl(exercises.getExerciseTitle());
            childChooseOneDTO.setRightWord(exercises.getCorrectAnswer());
            String[] strings = exercises.getWrongAnswer().split(";");
            childChooseOneDTO.setWrongWord(Arrays.asList(strings));
            childChooseOneDTOList.add(childChooseOneDTO);
        }
        return (T) childChooseOneDTOList;
    }

    /**
     * 幼儿选一选 二
     *
     * @param exercisesList 原始数据
     * @param <T>           需要返回的数据
     * @return 重新映射后的数据
     */
    public <T> T getListByExerciseTypeForChildChooseTwo(List<LearnExercisesLogDTO> exercisesList) {
        List<ChildChooseTwoDTO> childChooseTwoDTOS = new ArrayList<>();
        for (LearnExercisesLogDTO exercises : exercisesList) {
            ChildChooseTwoDTO childChooseTwoDTO = new ChildChooseTwoDTO();
            childChooseTwoDTO.setImageUrl(exercises.getExerciseTitle());
            childChooseTwoDTO.setRightWord(exercises.getCorrectAnswer());
            String[] strings = exercises.getWrongAnswer().split(";");
            childChooseTwoDTO.setWrongWord(Arrays.asList(strings));
            childChooseTwoDTOS.add(childChooseTwoDTO);
        }
        return (T) childChooseTwoDTOS;
    }

    /**
     * 幼儿找一找 一
     *
     * @param exercisesList 原始数据
     * @param <T>           需要返回的数据
     * @return 重新映射后的数据
     */
    public <T> T getListByExerciseTypeForChildFindOne(List<LearnExercisesLogDTO> exercisesList) {
        List<ChildFindOneDTO> childFindOneDTOList = new ArrayList<>();
        for (LearnExercisesLogDTO exercises : exercisesList) {
            ChildFindOneDTO childFindOneDTO = new ChildFindOneDTO();
            childFindOneDTO.setWord(exercises.getExerciseTitle());
            childFindOneDTO.setRightImageUrl(exercises.getCorrectAnswer());
            String[] strings = exercises.getWrongAnswer().split(";");
            childFindOneDTO.setWrongImageUrl(Arrays.asList(strings));
            childFindOneDTOList.add(childFindOneDTO);
        }
        return (T) childFindOneDTOList;
    }

    /**
     * 幼儿找一找 二
     *
     * @param exercisesList 原始数据
     * @param <T>           需要返回的数据
     * @return 重新映射后的数据
     */
    public <T> T getListByExerciseTypeForChildFindTwo(List<LearnExercisesLogDTO> exercisesList) {
        List<ChildFindTwoDTO> childFindTwoDTOS = new ArrayList<>();
        for (LearnExercisesLogDTO exercises : exercisesList) {
            ChildFindTwoDTO childFindTwoDTO = new ChildFindTwoDTO();
            childFindTwoDTO.setAudioUrl(exercises.getExerciseTitle());
            childFindTwoDTO.setRightImageUrl(exercises.getCorrectAnswer());
            String[] strings = exercises.getWrongAnswer().split(";");
            childFindTwoDTO.setWrongImageUrl(Arrays.asList(strings));
            childFindTwoDTOS.add(childFindTwoDTO);
        }
        return (T) childFindTwoDTOS;
    }

    /**
     * 幼儿跟读
     *
     * @param exercisesList 原始数据
     * @param <T>           需要返回的数据
     * @return 重新映射后的数据
     */
    public <T> T getListByExerciseTypeForChildFollow(List<LearnExercisesLogDTO> exercisesList) {
        List<ChildFollowDTO> childFollowDTOS = new ArrayList<>();
        for (LearnExercisesLogDTO exercises : exercisesList) {
            ChildFollowDTO childFollowDTO = new ChildFollowDTO();
            childFollowDTO.setWord(exercises.getExerciseTitle());
            childFollowDTOS.add(childFollowDTO);
        }
        return (T) childFollowDTOS;
    }


    /**
     * 返回少儿游戏数据
     *
     * @param exerciseType  游戏类型
     * @param exercisesList 输入数据
     * @param <T>           返回数据
     */
    private <T> T getListByExerciseTypeForJuvenile(Integer exerciseType, List<LearnExercisesLogDTO> exercisesList) {
        switch (exerciseType) {
            case 1:
                return getListByExerciseTypeForJuvenileChooseWord(exercisesList);
            case 2:
                return getListByExerciseTypeForJuvenileEliminate(exercisesList);
            case 3:
                return getListByExerciseTypeForJuvenileFellow(exercisesList);
            default:
                throw new NullPointerException("非法的exerciseType参数");
        }
    }

    private <T> T getListByExerciseTypeForJuvenileChooseWord(List<LearnExercisesLogDTO> exercisesList) {
        List<JuvenileChooseWordDTO> juvenileChooseWordDTOS = new ArrayList<>();
        for (LearnExercisesLogDTO exercises : exercisesList) {
            JuvenileChooseWordDTO juvenileChooseWordDTO = new JuvenileChooseWordDTO();
            juvenileChooseWordDTO.setComments(exercises.getExerciseTitle());
            juvenileChooseWordDTO.setRightWord(exercises.getCorrectAnswer());
            String[] strings = exercises.getWrongAnswer().split(";");
            juvenileChooseWordDTO.setWrongWord(Arrays.asList(strings));
            juvenileChooseWordDTOS.add(juvenileChooseWordDTO);
        }
        return (T) juvenileChooseWordDTOS;
    }

    /**
     * 少儿消消乐
     *
     * @param exercisesList 原始数据
     * @param <T>           需要返回的数据
     * @return 重新映射后的数据
     */
    private <T> T getListByExerciseTypeForJuvenileEliminate(List<LearnExercisesLogDTO> exercisesList) {
        List<JuvenileEliminateDTO> juvenileEliminateDTOS = new ArrayList<>();
        for (LearnExercisesLogDTO exercises : exercisesList) {
            JuvenileEliminateDTO juvenileEliminateDTO = new JuvenileEliminateDTO();
            String[] strings1 = exercises.getCorrectAnswer().split(";");
            juvenileEliminateDTO.setLeftWords(Arrays.asList(strings1));
            String[] strings = exercises.getWrongAnswer().split(";");
            juvenileEliminateDTO.setRightWords(Arrays.asList(strings));
            juvenileEliminateDTOS.add(juvenileEliminateDTO);
        }
        return (T) juvenileEliminateDTOS;
    }


    /**
     * 少儿跟读
     *
     * @param exercisesList 原始数据
     * @param <T>           需要返回的数据
     * @return 重新映射后的数据
     */
    private <T> T getListByExerciseTypeForJuvenileFellow(List<LearnExercisesLogDTO> exercisesList) {
        List<JuvenileFellowDTO> juvenileFellowDTOS = new ArrayList<>();
        for (LearnExercisesLogDTO exercises : exercisesList) {
            JuvenileFellowDTO juvenileFellowDTO = new JuvenileFellowDTO();
            juvenileFellowDTO.setWord(exercises.getExerciseTitle());
            juvenileFellowDTOS.add(juvenileFellowDTO);
        }
        return (T) juvenileFellowDTOS;
    }

    /**
     * 获取数据
     */
    @PostConstruct
    public void getSumGroupbyGrade(){
        List<IndexDataInfoDTO> sumGroupbyGrade = exercisesMapper.getSumGroupbyGrade();
        if (sumGroupbyGrade != null && sumGroupbyGrade.size() > 0) {
            for (IndexDataInfoDTO indexDataInfoDTO : sumGroupbyGrade) {
                sumGroupbyGradeMap.put(indexDataInfoDTO.getDays(), Integer.parseInt(indexDataInfoDTO.getSpeed()));
            }
        }
    }


}
