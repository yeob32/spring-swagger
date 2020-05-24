package com.example.demo.config;

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

import java.util.ArrayList;

@EnableSwagger2
@Configuration
//@EnableSwagger2WebMvcx
//@Import(SpringDataRestConfiguration.class)
public class SpringFoxConfig {
    private String version;
    private String title;

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

    @Bean
    public Docket apiV2() {
        version = "V2";
        title = "victolee API " + version;

        return new Docket(DocumentationType.SWAGGER_2)
                .useDefaultResponseMessages(false)
                .groupName(version)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.demo.api"))
//                .paths(PathSelectors.ant("/v2/api/**"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo(title, version));
    }

    private ApiInfo apiInfo(String title, String version) {
        return new ApiInfoBuilder()
                .title(title)
                .description("Swagger로 생성한 API Docs")
                .version(version)
                .termsOfServiceUrl("www.example.com")
                .contact(new Contact("Contact Me", "www.example.com", "foo@example.com"))
                .license("Licenses")
                .licenseUrl("www.example.com")
                .extensions(new ArrayList<>())
                .build();
    }
}
