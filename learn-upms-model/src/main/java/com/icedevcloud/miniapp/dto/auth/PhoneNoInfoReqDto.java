package com.icedevcloud.miniapp.dto.auth;

import lombok.Data;

/**
 * PhoneNoInfoReqDto
 *
 * @author XiaoBingBy
 * @since 2021-01-01
 */
@Data
public class PhoneNoInfoReqDto {

    private String encryptedData;

    private String ivStr;

}
