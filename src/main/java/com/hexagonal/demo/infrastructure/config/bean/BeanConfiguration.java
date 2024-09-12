package com.hexagonal.demo.infrastructure.config.bean;

import com.hexagonal.demo.application.ports.input.CategoryUseCase;
import com.hexagonal.demo.application.ports.output.CategoryOutputPort;
import com.hexagonal.demo.application.service.CategoryService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = BeanConfiguration.class)
public class BeanConfiguration {

    @Bean
    CategoryUseCase categoryService(final CategoryOutputPort outputPort) {
        return new CategoryService(outputPort);
    }
}
