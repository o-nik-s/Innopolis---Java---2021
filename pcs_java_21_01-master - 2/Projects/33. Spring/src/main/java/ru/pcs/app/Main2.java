package ru.pcs.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
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
        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        SignUpService signUpService = context.getBean(SignUpService.class);
        int i = 0;
    }
}
