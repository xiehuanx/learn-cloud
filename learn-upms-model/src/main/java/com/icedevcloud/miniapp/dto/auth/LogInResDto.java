package com.icedevcloud.miniapp.dto.auth;

import com.icedevcloud.common.entity.WxUserInfo;
import lombok.Data;

@Data
public class LogInResDto {

    private String token;

    private WxUserInfo wxUserInfo;

}
