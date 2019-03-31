package com.xiaofeng.mybatisplus;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.async.DeferredResult;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @Auther: 晓枫
 * @Date: 2019/3/29 23:05
 * @Description:
 */
@Configuration
public class Swagger2 {
//    @Bean
//    public Docket createRestApi() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .apiInfo(apiInfo())
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.xiaofeng.mybatisplus"))
//                .paths(PathSelectors.any())
//                .build();
//    }
//
//    private ApiInfo apiInfo() {
//        return new ApiInfoBuilder()
//                .title("springboot整合mybatis plus与swagger2")
//                .description("简单优雅的restfun风格")
//                .termsOfServiceUrl("http://ymyhome.cn")
//                .version("1.0")
//                .build();
//    }

    @Bean
    public Docket ProductApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .genericModelSubstitutes(DeferredResult.class)
                .useDefaultResponseMessages(false)
                .forCodeGeneration(false)
                .pathMapping("/")
                .select()
                .build()
                .apiInfo(productApiInfo());
    }

    private ApiInfo productApiInfo() {
        ApiInfo apiInfo = new ApiInfo("测试系统数据接口文档",
                "文档描述",
                "1.0.0",
                "API TERMS URL",
                "1158119024",
                "license",
                "license url");
        return apiInfo;
    }
}
