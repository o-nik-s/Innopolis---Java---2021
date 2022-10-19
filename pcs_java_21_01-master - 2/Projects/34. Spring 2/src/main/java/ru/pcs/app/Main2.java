package ru.pcs.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.pcs.config.ApplicationConfig;
import ru.pcs.services.SignUpService;
import ru.pcs.validators.PasswordValidator;

/**
 * 29.10.2021
 * 33. Spring
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Main2 {
    public static void main(String[] args) {
//        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        SignUpService signUpService = context.getBean(SignUpService.class);
        signUpService.signUp("java@java.com", "sadfwe0900!!");
    }
}
