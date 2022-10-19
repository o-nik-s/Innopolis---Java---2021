package ru.pcs.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.pcs.models.Account;
import ru.pcs.repositories.AccountsRepository;

/**
 * 29.10.2021
 * 33. Spring
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@Service(value = "signUpService")
@RequiredArgsConstructor
public class SignUpServiceImpl implements SignUpService {

    private final AccountsRepository accountsRepository;

    @Override
    public void signUp(String email, String password) {

        Account account = Account.builder()
                .email(email)
                .password(password)
                .build();

        accountsRepository.save(account);
    }
}
