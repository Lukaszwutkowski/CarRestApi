package com.homework2springboot.carrestapi.config;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class SpringDocConfig implements WebMvcConfigurer {

    @Bean
    public GroupedOpenApi api(){
        return GroupedOpenApi.builder()
                .group("api")
                .packagesToScan("com.homework2springboot.car-restapi")
                .build();
    }
}
