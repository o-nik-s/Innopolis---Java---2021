package ru.pcs.web.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.pcs.web.dto.AccountDto;
import ru.pcs.web.models.Account;
import ru.pcs.web.repositories.AccountsRepository;

import java.util.List;

import static ru.pcs.web.dto.AccountDto.from;

/**
 * 10.11.2021
 * 42. Spring Boot Security - MVC
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@RequiredArgsConstructor
@Service
public class AccountsServiceImpl implements AccountsService {

    private final AccountsRepository accountsRepository;

    @Override
    public List<AccountDto> getAllAccounts() {
        return from(accountsRepository.findAllByState(Account.State.CONFIRMED));
    }

    @Override
    public void deleteAccount(Long accountId) {
        Account account = accountsRepository.getById(accountId);
        account.setState(Account.State.DELETED);
        accountsRepository.save(account);
    }
}
