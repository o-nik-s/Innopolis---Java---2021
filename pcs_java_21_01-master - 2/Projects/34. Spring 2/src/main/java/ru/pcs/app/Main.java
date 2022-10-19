package ru.pcs.app;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import ru.pcs.blacklist.PasswordsBlacklist;
import ru.pcs.blacklist.PasswordsBlacklistInMemoryImpl;
import ru.pcs.repositories.AccountsRepository;
import ru.pcs.repositories.AccountsRepositoryJdbcImpl;
import ru.pcs.services.SignUpService;
import ru.pcs.services.SignUpServiceImpl;
import ru.pcs.validators.EmailValidator;
import ru.pcs.validators.EmailValidatorRegexImpl;
import ru.pcs.validators.PasswordValidator;
import ru.pcs.validators.PasswordValidatorByLengthImpl;

/**
 * 29.10.2021
 * 33. Spring
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Main {
    public static void main(String[] args) {
        HikariConfig config = new HikariConfig();
        config.setUsername("postgres");
        config.setPassword("qwerty007");
        config.setDriverClassName("org.postgresql.Driver");
        config.setJdbcUrl("jdbc:postgresql://localhost:5432/pcs_test");
        config.setMaximumPoolSize(20);
        HikariDataSource dataSource = new HikariDataSource(config);

        PasswordValidator passwordValidator = new PasswordValidatorByLengthImpl(5);
        EmailValidatorRegexImpl emailValidator = new EmailValidatorRegexImpl();
        emailValidator.setPattern(".+@.+");
        PasswordsBlacklist blacklist = new PasswordsBlacklistInMemoryImpl();
        AccountsRepository accountsRepository = new AccountsRepositoryJdbcImpl(dataSource);

        SignUpService signUpService =
                new SignUpServiceImpl(blacklist, emailValidator, passwordValidator, accountsRepository);

        signUpService.signUp("sidikov.marsel@gmail.com", "qwerty008");

    }
}
