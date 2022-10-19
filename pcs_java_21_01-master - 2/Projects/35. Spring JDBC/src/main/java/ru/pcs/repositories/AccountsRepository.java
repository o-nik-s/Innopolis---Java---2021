package ru.pcs.repositories;


import ru.pcs.models.Account;

import java.util.List;
import java.util.Optional;

/**
 * 04.10.2021
 * 24. JDBC Repository
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public interface AccountsRepository {
    void save(Account student);

    List<Account> findAllByEmail(String email);

    Optional<Account> findById(Long id);
}
