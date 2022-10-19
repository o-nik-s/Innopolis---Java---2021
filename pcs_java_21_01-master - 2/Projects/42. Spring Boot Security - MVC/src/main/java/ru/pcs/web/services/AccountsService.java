package ru.pcs.web.services;

import ru.pcs.web.dto.AccountDto;

import java.util.List;

/**
 * 10.11.2021
 * 42. Spring Boot Security - MVC
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public interface AccountsService {
    List<AccountDto> getAllAccounts();

    void deleteAccount(Long accountId);
}
