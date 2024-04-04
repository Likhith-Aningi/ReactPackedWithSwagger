package com.example.reactpacked.config;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@SecurityScheme(
        name = "jwtSec",
        in = SecuritySchemeIn.HEADER,
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        scheme = "bearer",
        description = "admin sec description"
)
public class SwaggerConfig {
    @Bean
    OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Likhith's api definitions")
                        .version("Api version 0.0..")
                        .description("This is reference description using swagger for spring boot rest apis")
                        .contact(new Contact()
                                .email("likhith.a@way2news.com")
                                .name("Likhith Aningi")
                        )
                        .summary("Summary Lorem ipsum dolor sit, amet consectetur adipisicing elit. Aut, ea? Harum dolore reprehenderit nobis eius explicabo repellendus, molestiae dolores! Unde quis necessitatibus obcaecati, aliquam provident explicabo incidunt perferendis fugiat laudantium!")

                ).servers(List.of(
                                new Server()
                                        .description("dev-env")
                                        .url("http://localhost:8081"
                                        )
                        )
                );
    }

    @Bean
    GroupedOpenApi groupedOpenApi() {
        return GroupedOpenApi.builder()
                .group("dev-docs")
                .pathsToMatch("/**")
                .build();
    }

    @Bean
    GroupedOpenApi publicGroupedOpenApi() {
        return GroupedOpenApi.builder()
                .group("public")
                .pathsToMatch("/api/**")
                .pathsToExclude("/api/admin/**", "/api/user/**")
                .build();
    }

    @Bean
    GroupedOpenApi adminGroupedOpenApi() {
        return GroupedOpenApi.builder()
                .group("admin")
                .pathsToMatch("/api/admin/**")
                .build();
    }

    @Bean
    GroupedOpenApi userGroupedOpenApi() {
        return GroupedOpenApi.builder()
                .group("user")
                .pathsToMatch("/api/user/**")
                .build();
    }
}
