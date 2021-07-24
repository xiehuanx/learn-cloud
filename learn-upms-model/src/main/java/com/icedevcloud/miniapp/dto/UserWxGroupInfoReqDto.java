package com.icedevcloud.miniapp.dto;

import lombok.Data;

@Data
public class UserWxGroupInfoReqDto {

    private Long current = 1L;

    private Long pageSize = 10L;

    private Long userId;

}
