package ru.pcs.web.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
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
@Service
@RequiredArgsConstructor
public class AccountsServiceImpl implements AccountsService {

    private final AccountsRepository accountsRepository;

    @Override
    public List<AccountDto> getAll() {
        return from(accountsRepository.findAll());
    }

    @Override
    public void addUser(AccountDto user) {
        Account account = Account.builder()
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .build();

        accountsRepository.save(account);
    }

    @Override
    public AccountDto getInformation(Long userId) {
        return from(accountsRepository.getById(userId));
    }
}
