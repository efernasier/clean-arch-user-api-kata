package com.kata.users.app.spring;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.kata.users.adapter.controller.UserController;
import com.kata.users.adapter.repository.jpa.postgres.JpaPostgresUserRepository;
import com.kata.users.config.SpringConfig;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(basePackages = {"com.kata.users.adapter.repository.jpa.postgres.entity"})
@EnableJpaRepositories(basePackages = {"com.kata.users.adapter.repository.jpa.postgres"})
public class Config {

    private final SpringConfig config = new SpringConfig();

    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        return objectMapper;
    }

    @Bean
    public UserController userController(JpaPostgresUserRepository repository){
        return config.userController(repository);
    }

}
