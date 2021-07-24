package com.icedevcloud.cp.dto.order;

import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.Data;

import java.io.Serializable;

/**
 * author :xiehuan
 * Email: 1487471733@qq.com
 * Date: 2021/4/29
 * Describe:
 */
@Data
public class QueryActivityOrderByActivityIdRespDto implements Serializable {

    private IPage<QueryActivityOrderByActivityIdDto> queryActivityOrderByActivityIdDtos;

    private String boysNumber;

    private String girlsNumber;


}
