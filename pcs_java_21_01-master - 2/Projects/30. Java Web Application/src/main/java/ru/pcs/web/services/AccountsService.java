package ru.pcs.web.services;

import ru.pcs.web.dto.AccountDto;
import ru.pcs.web.models.Account;

import java.util.List;

/**
 * 18.10.2021
 * 30. Java Web Application
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public interface AccountsService {
    List<AccountDto> getAll();
    List<AccountDto> searchByEmail(String email);
}
