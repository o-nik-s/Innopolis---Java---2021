package ru.pcs.repository;

import java.util.List;

/**
 * 13.10.2021
 * 28. JUnit
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public interface AccountsRepository {
    List<Account> findAll();
}
