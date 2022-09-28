package com.managementstudents.configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components())
                .info(new Info().title("Students Management API").version("v1.0")
                        .description("This is a sample Spring Boot RESTful service using springdoc-openapi and OpenAPI 3.")
                        .termsOfService("http://swagger.io/terms/")
                        .contact(new Contact().email("varreagae@unemi.edu.ec").name("Víctor Arreaga").url("https://github.com/vfred0"))
                        .license(new License().name("Apache 2.0").url("http://springdoc.org")));
    }


}
