package com.kay.practice.servicemain.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Swagger配置
 *
 * @author Kay
 * @date 2020-10-23
 */
@Configuration
@EnableOpenApi
public class SwaggerConfig {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.OAS_30)
                .pathMapping("/")
                .enable(true)
                .apiInfo(this.apiInfo())
                //指定需要发布到Swagger的接口目录,不支持通配符
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.kay.practice.servicemain.controller"))
                .paths(PathSelectors.any())
                .build()
                //支持的通讯协议集合
                .protocols(this.newHashSet("https", "http"));
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Swagger Api Doc")
                .description("service-main 后端接口")
                .contact(new Contact("Kay", "", ""))
                .version("1.0")
                .build();
    }

    @SafeVarargs
    private final <T> Set<T> newHashSet(T... ts) {
        if (ts.length > 0) {
            return new LinkedHashSet<>(Arrays.asList(ts));
        }
        return null;
    }
}
