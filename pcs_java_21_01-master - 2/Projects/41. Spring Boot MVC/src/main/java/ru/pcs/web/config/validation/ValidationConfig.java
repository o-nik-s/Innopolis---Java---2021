package ru.pcs.web.config.validation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.DefaultMessageCodesResolver;
import org.springframework.validation.MessageCodeFormatter;
import org.springframework.validation.MessageCodesResolver;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

/**
 * 08.11.2021
 * 41. Spring Boot MVC
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 *
 */
@Configuration
public class ValidationConfig {

    @Bean
    public LocalValidatorFactoryBean localValidatorFactoryBean() {
        return new LocalValidatorFactoryBean();
    }
}
