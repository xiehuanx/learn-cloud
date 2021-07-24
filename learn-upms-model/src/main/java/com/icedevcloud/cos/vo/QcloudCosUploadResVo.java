package com.icedevcloud.cos.vo;

import lombok.Data;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Data
public class QcloudCosUploadResVo {

    private String eTag;

    private String crc64Ecma;

    private String key;

    private String domainKey;

}
