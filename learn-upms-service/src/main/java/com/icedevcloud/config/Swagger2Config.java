package com.icedevcloud.config;

import com.google.common.collect.Sets;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2Config {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("cp-upms")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.icedevcloud"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("cp-upms 服务")
                .description("cp-upms api接口文档简要描述")
                .termsOfServiceUrl("http://localhost:5001/")
                .version("0.0.1")
                .license("Apache License 2.0")
                .licenseUrl("https://gitee.com/icedevcloud/cp-cloud/raw/master/LICENSE")
                .contact(new Contact("icedevcloud", "https://gitee.com/icedevcloud", "XiaoBingBy@Gmail.com"))
                .build();
    }

}
