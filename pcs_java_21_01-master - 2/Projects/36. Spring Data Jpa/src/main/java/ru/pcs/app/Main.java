package ru.pcs.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.pcs.config.ApplicationConfig;
import ru.pcs.models.Account;
import ru.pcs.repositories.AccountsRepository;
import ru.pcs.services.SignUpService;

/**
 * 29.10.2021
 * 33. Spring
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        SignUpService signUpService = context.getBean(SignUpService.class);
        AccountsRepository accountsRepository = context.getBean(AccountsRepository.class);
        Account account = Account.builder()
                .email("marsel@gmail.com")
                .password("qwert007")
                .build();
        accountsRepository.save(account);
        System.out.println(account);
    }
}
