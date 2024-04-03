package com.example.reactpacked.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    GroupedOpenApi groupedOpenApi(){
        return  GroupedOpenApi.builder()
                .group("dev-docs")
                .pathsToMatch("/**")
                .build();
    }
    @Bean
    OpenAPI customOpenAPI(){
        return new OpenAPI()
                .info(new Info()
                        .title("Sample api title")
                        .version("Api version 0.0..")
                        .description("This is reference description using swagger for spring boot rest apis")
                        .contact(new Contact()
                                .email("likhith.a@way2news.com")
                                .name("Likhith Aningi")
                        )
                        .summary("Summary Lorem ipsum dolor sit, amet consectetur adipisicing elit. Aut, ea? Harum dolore reprehenderit nobis eius explicabo repellendus, molestiae dolores! Unde quis necessitatibus obcaecati, aliquam provident explicabo incidunt perferendis fugiat laudantium!")
                );
    }
}
