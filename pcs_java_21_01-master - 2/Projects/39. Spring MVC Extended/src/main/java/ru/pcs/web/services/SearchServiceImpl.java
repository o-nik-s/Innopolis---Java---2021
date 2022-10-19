package ru.pcs.web.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.pcs.web.dto.AccountDto;
import ru.pcs.web.repositories.AccountsRepository;

import java.util.List;

import static ru.pcs.web.dto.AccountDto.from;

/**
 * 03.11.2021
 * 39. Spring MVC Extended
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@RequiredArgsConstructor
@Service
public class SearchServiceImpl implements SearchService {

    private final AccountsRepository accountsRepository;

    @Override
    public List<AccountDto> searchUsersByEmail(String email) {
        return from(accountsRepository.findAllByEmailLikeIgnoreCase("%" + email + "%"));
    }
}
