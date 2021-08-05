package com.crud.livrariaWeb.doc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket detalheApi() {

        ParameterBuilder paramBuilder = new ParameterBuilder();
        List<Parameter> params = new ArrayList<>();
        paramBuilder.name("Authorization").modelRef(new ModelRef("string"))
                .parameterType("header")
                .required(false)
                .build();

        params.add(paramBuilder.build());

        Docket docket = new Docket(DocumentationType.SWAGGER_2);

        docket
                .globalOperationParameters(params)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.crud.livrariaWeb"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(this.informacoesApi().build())
                .consumes(new HashSet<>(Arrays.asList("application/json")))
                .produces(new HashSet<>(Arrays.asList("application/json")));

        return docket;
    }
    private ApiInfoBuilder informacoesApi() {

        ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();

        apiInfoBuilder.title("IFPE - API");
        apiInfoBuilder.description("API IFPE ");
        apiInfoBuilder.version("1.0");
        apiInfoBuilder.termsOfServiceUrl("Termo de uso: IFPE");
        apiInfoBuilder.license("Licença - IFPE");
        apiInfoBuilder.licenseUrl("https://IFPE.com/");

        return apiInfoBuilder;
    }

}

//http://localhost:8090/swagger-ui.html#
