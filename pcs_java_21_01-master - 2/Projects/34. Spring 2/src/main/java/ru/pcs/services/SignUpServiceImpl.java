package ru.pcs.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.pcs.blacklist.PasswordsBlacklist;
import ru.pcs.models.Account;
import ru.pcs.repositories.AccountsRepository;
import ru.pcs.validators.EmailValidator;
import ru.pcs.validators.PasswordValidator;

/**
 * 29.10.2021
 * 33. Spring
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@Service(value = "signUpService")
public class SignUpServiceImpl implements SignUpService {

    private final PasswordsBlacklist passwordsBlacklist;
    private final EmailValidator emailValidator;
    private final PasswordValidator passwordValidator;
    private final AccountsRepository accountsRepository;

    @Autowired
    public SignUpServiceImpl(PasswordsBlacklist passwordsBlacklist,
                             @Qualifier("emailValidatorByLength") EmailValidator emailValidator,
                             @Qualifier("byLength") PasswordValidator passwordValidator,
                             AccountsRepository accountsRepository) {
        this.passwordsBlacklist = passwordsBlacklist;
        this.emailValidator = emailValidator;
        this.passwordValidator = passwordValidator;
        this.accountsRepository = accountsRepository;
    }

    @Override
    public void signUp(String email, String password) {

        if (passwordsBlacklist.contains(password)) {
            throw new IllegalArgumentException("Пароль уже был взломан");
        }

        emailValidator.validate(email);
        passwordValidator.validate(password);

        Account account = Account.builder()
                .email(email)
                .password(password)
                .build();

        accountsRepository.save(account);
    }
}
