/**
 * projectName: fendo-plus-boot
 * fileName: SwaggerConfig.java
 * packageName: com.gzsys.common.config
 * date: 2018-02-01 1:14
 * copyright(c) 2017-2020 xxx公司
 */
package com.dlf.garment3.config;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @version: V1.0
 * @author: fendo
 * @className: SwaggerConfig
 * @packageName: com.gzsys.common.config
 * @description: Swagger配置文件
 * @data: 2018-02-01 1:14
 **/
@Configuration
@EnableSwagger2
//@Profile({"dev", "test"})
public class SwaggerConfig {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))           //加了ApiOperation注解的方法，生成接口文档
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("贯众健康API文档")
                .description("GZSYS项目API文档")
                .termsOfServiceUrl("http://blog.csdn.net/u011781521?viewmode=contents")
                .version("1.0")
                .contact("fendo")//作者
                .license("The Apache License, Version 2.0")
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
                .build();
    }

}
