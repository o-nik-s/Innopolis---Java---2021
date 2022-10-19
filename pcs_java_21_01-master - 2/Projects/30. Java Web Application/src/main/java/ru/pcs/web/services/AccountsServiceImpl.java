package ru.pcs.web.services;

import ru.pcs.web.dto.AccountDto;
import ru.pcs.web.models.Account;
import ru.pcs.web.repositories.AccountsRepository;

import java.util.List;

import static ru.pcs.web.dto.AccountDto.from;

/**
 * 18.10.2021
 * 30. Java Web Application
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class AccountsServiceImpl implements AccountsService {

    private final AccountsRepository accountsRepository;

    public AccountsServiceImpl(AccountsRepository accountsRepository) {
        this.accountsRepository = accountsRepository;
    }

    @Override
    public List<AccountDto> getAll() {
        return from(accountsRepository.findAll());
    }

    @Override
    public List<AccountDto> searchByEmail(String email) {
        return from(accountsRepository.searchByEmail(email));
    }
}
