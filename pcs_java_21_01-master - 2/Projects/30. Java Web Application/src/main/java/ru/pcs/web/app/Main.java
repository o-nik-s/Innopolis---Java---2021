package ru.pcs.web.app;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import ru.pcs.web.dto.SignUpForm;
import ru.pcs.web.repositories.AccountsRepository;
import ru.pcs.web.repositories.AccountsRepositoryJdbcImpl;
import ru.pcs.web.services.SignUpService;
import ru.pcs.web.services.SignUpServiceImpl;

import java.util.Properties;

/**
 * 18.10.2021
 * 30. Java Web Application
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Main {
    public static void main(String[] args) {
        Properties properties = new Properties();
        try {
            properties.load(ClassLoader.getSystemResourceAsStream("application.properties"));
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }

        HikariConfig config = new HikariConfig();
        config.setUsername(properties.getProperty("db.user"));
        config.setPassword(properties.getProperty("db.password"));
        config.setDriverClassName(properties.getProperty("db.driver-class-name"));
        config.setJdbcUrl(properties.getProperty("db.url"));
        config.setMaximumPoolSize(Integer.parseInt(properties.getProperty("db.hikari.max-pool-size")));
        HikariDataSource dataSource = new HikariDataSource(config);

        AccountsRepository accountsRepository = new AccountsRepositoryJdbcImpl(dataSource);
        SignUpService signUpService = new SignUpServiceImpl(accountsRepository);

        SignUpForm form = SignUpForm.builder()
                .email("Sidikov.Marsel@gmail.com")
                .password("qwerty007")
                .firstName("Marsel")
                .lastName("Sidikov")
                .build();
        signUpService.signUp(form);

        System.out.println(accountsRepository.findAll());
    }
}
