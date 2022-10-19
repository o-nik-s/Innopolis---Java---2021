package ru.pcs.web.services;

import ru.pcs.web.dto.SignInForm;
import ru.pcs.web.models.Account;
import ru.pcs.web.repositories.AccountsRepository;

import java.util.Optional;

/**
 * 18.10.2021
 * 30. Java Web Application
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class SignInServiceImpl implements SignInService {

    private final AccountsRepository accountsRepository;

    public SignInServiceImpl(AccountsRepository accountsRepository) {
        this.accountsRepository = accountsRepository;
    }

    @Override
    public boolean doAuthenticate(SignInForm form) {
        return accountsRepository.findByEmail(form.getEmail())
                .map(account -> account.getPassword().equals(form.getPassword()))
                .orElse(false);

    }
}
