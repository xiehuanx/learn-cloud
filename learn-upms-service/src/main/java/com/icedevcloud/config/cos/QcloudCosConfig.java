package com.icedevcloud.config.cos;

import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.region.Region;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author XiaoBingBy
 * @since 2020-05-19 18:32
 */
@Slf4j
@Configuration
@EnableConfigurationProperties(QcloudCosProperties.class)
public class QcloudCosConfig {

    private final QcloudCosProperties qcloudCosProperties;

    public QcloudCosConfig(QcloudCosProperties qcloudCosProperties) {
        this.qcloudCosProperties = qcloudCosProperties;
    }

    @Bean
    public COSClient cosClient() {
        // 1 初始化用户身份信息（secretId, secretKey）。
        String secretId = qcloudCosProperties.getSecretId();
        String secretKey = qcloudCosProperties.getSecretKey();
        COSCredentials cred = new BasicCOSCredentials(secretId, secretKey);

        // 2 设置 bucket 的区域, COS 地域的简称请参照 https://cloud.tencent.com/document/product/436/6224
        // clientConfig 中包含了设置 region, https(默认 http), 超时, 代理等 set 方法, 使用可参见源码或者常见问题 Java SDK 部分。
        Region region = new Region(qcloudCosProperties.getRegionName());
        ClientConfig clientConfig = new ClientConfig(region);

        // 3 生成 cos 客户端。
        COSClient cosClient = new COSClient(cred, clientConfig);

        return cosClient;
    }

}
