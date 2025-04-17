package com.example.config;

import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI moneyTransferOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Money Transfer API")
                        .description("REST API for transferring funds between accounts")
                        .version("v1.0"));
    }
}
