package com.icedevcloud.common.controller;


import com.icedevcloud.common.core.api.R;
import com.icedevcloud.common.dto.BaseAreaTreeResDto;
import com.icedevcloud.common.entity.BaseArea;
import com.icedevcloud.common.service.IBaseAreaService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 基础地区 前端控制器
 * </p>
 *
 * @author XiaoBingBy
 * @since 2021-04-11
 */
@RestController
@RequestMapping("/api/common/baseArea")
public class BaseAreaController {

    @Autowired
    private IBaseAreaService iBaseAreaService;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public static Map<String, String> map= new HashMap<>();

    public static Map<Integer, String> genderMap = new HashMap<>();

    public static Map<Integer, String> degreeMap = new HashMap<>();

    public static Map<Integer, String> statusMap = new HashMap<>();


    @ApiOperation("queryAllBaseAreaTree")
    @PostMapping("queryAllBaseAreaTree")
    public R<List<BaseAreaTreeResDto>> queryAllBaseAreaTree() {
        List<BaseAreaTreeResDto> baseAreaTreeResDtos = iBaseAreaService.queryAllBaseAreaTree();
        return R.ok(baseAreaTreeResDtos);
    }

    @PostConstruct
    public void forward(){
        List<BaseArea> baseAreas = iBaseAreaService.list();
        for (BaseArea baseArea : baseAreas) {
            map.put(baseArea.getAreaCode(), baseArea.getAreaName());
        }
        genderMap.put(0, "未知");
        genderMap.put(1, "男");
        genderMap.put(2, "女");

        degreeMap.put(1, "专科");
        degreeMap.put(2, "本科");
        degreeMap.put(3, "硕士");
        degreeMap.put(4, "博士");

        statusMap.put(1, "未开始");
        statusMap.put(2, "进行中");
        statusMap.put(3, "已结束");

        System.out.println("11111");
    }

}
