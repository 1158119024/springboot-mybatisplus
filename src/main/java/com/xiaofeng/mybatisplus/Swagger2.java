package com.xiaofeng.mybatisplus;

import com.google.common.collect.Lists;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.web.context.request.async.DeferredResult;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.List;

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
////
//    private ApiInfo apiInfo() {
//        return new ApiInfoBuilder()
//                .title("springboot整合mybatis plus与swagger2")
//                .description("简单优雅的restfun风格")
//                .termsOfServiceUrl("http://ymyhome.cn")
//                .version("1.0")
//                .build();
//    }

    // layer ui
//    @Bean
//    public Docket ProductApi() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .genericModelSubstitutes(DeferredResult.class)
//                .useDefaultResponseMessages(false)
//                .forCodeGeneration(false)
//                .pathMapping("/")
//                .select()
//                .build()
//                .apiInfo(apiInfo());
//    }
//
//    private ApiInfo apiInfo() {
//        ApiInfo apiInfo = new ApiInfo("测试系统数据接口文档",
//                "文档描述",
//                "1.0.0",
//                "API TERMS URL",
//                "1158119024",
//                "license",
//                "license url");
//        return apiInfo;
//    }

    // bootstrap ui
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
//                .title("swagger-bootstrap-ui RESTful APIs")
//                .description("swagger-bootstrap-ui")
//                .termsOfServiceUrl("http://ymyhome.cn")
//                .version("1.0")
//                .build();
//    }

    @Bean(value = "defaultApi")
    @Order(value = 4)
    public Docket defaultApi() {
        ParameterBuilder parameterBuilder=new ParameterBuilder();
        List<Parameter> parameters= Lists.newArrayList();
        parameterBuilder.name("token").description("token令牌").modelRef(new ModelRef("String"))
                .parameterType("header")
                .required(true).build();
        parameters.add(parameterBuilder.build());

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("默认接口")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.xiaofeng.mybatisplus"))
                //.apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build().globalOperationParameters(parameters);
    }
    @Bean(value = "groupRestApi")
    @Order(value = 1)
    public Docket groupRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(groupApiInfo())
                .groupName("分组接口")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.xiaofeng.mybatisplus"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo groupApiInfo(){
        return new ApiInfoBuilder()
                .title("swagger-bootstrap-ui很棒~~~！！！")
                .description("<div style='font-size:14px;color:red;'>swagger-bootstrap-ui-demo RESTful APIs</div>")
                .termsOfServiceUrl("http://www.group.com/")
                .contact("group@qq.com")
                .version("1.0")
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("swagger-bootstrap-ui-demo RESTful APIs")
                .description("swagger-bootstrap-ui-demo RESTful APIs")
                .termsOfServiceUrl("http://www.xx.com/")
                .contact("xx@qq.com")
                .version("1.0")
                .build();
    }
}
