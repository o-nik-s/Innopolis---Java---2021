package ru.pcs.web.services;

import ru.pcs.web.dto.AccountDto;

import java.util.List;

/**
 * 03.11.2021
 * 39. Spring MVC Extended
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public interface SearchService {
    List<AccountDto> searchUsersByEmail(String email);
}
