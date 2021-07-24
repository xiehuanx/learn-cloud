package com.icedevcloud.miniapp.dto.auth;

import lombok.Data;

@Data
public class LogInReqDto {

    private String code;

    private String openId;

    private String nickName;

    private String gender;

    private String language;

    private String city;

    private String province;

    private String country;

    private String avatarUrl;

    private String unionId;

    private PhoneNoInfoReqDto phoneNoInfo;

}
