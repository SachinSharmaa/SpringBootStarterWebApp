package com.example.demo.config.swagger;

import com.example.demo.constants.ApplicationConstants;
import com.example.demo.properties.ApplicationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api(ApplicationProperties applicationProperties) {
        return new Docket(DocumentationType.SWAGGER_2).globalOperationParameters(getParameters()).
                apiInfo(getApiInfo(applicationProperties))
                .select().apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                .build();
    }

    private List<Parameter> getParameters() {
        Parameter parameter = new ParameterBuilder()
                .name(ApplicationConstants.AUTHORIZATION_HEADER)
                .modelRef(new ModelRef("string"))
                .required(true)
                .parameterType("header")
                .description("Basic Auth")
                .build();
        return Collections.singletonList(parameter);
    }

    private ApiInfo getApiInfo(ApplicationProperties applicationProperties) {
        return new ApiInfoBuilder().title(applicationProperties.getApplicationName())
                .version(applicationProperties.getApplicationVersion())
                .build();
    }

}
