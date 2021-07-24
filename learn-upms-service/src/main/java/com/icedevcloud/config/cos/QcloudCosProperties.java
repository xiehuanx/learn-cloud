package com.icedevcloud.config.cos;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author XiaoBingBy
 * @since 2020-05-21 09:25
 */
@Data
@Accessors(chain = true)
@ConfigurationProperties(prefix = "qcloud")
public class QcloudCosProperties {

    private String secretId;

    private String secretKey;

    private String regionName;

    private String bucketName;

    private String domainName;

}
