package com.iwhale.dynamic.config;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author DuebassLei
 * @version 1.0
 * @date 2021/6/10 14:37
 * Swagger2 配置
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {
    @Bean
    public Docket testConfig(){
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("dynamic api")
                .apiInfo(new ApiInfoBuilder()
                        .title("Dynamic-Database API文档")
                        .description("本文档描述了api接口定义")
                        .version("1.0")
                        .contact(new Contact("DuebassLei", "https://blog.gaosanshi.top/", "1130122701@qq.com"))
                        .build())
                .select()
                .paths(Predicates.and(PathSelectors.regex("/controller/.*")))
                .build();
    }
}
