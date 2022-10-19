package ru.pcs.web.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.pcs.web.models.Account;

import java.util.List;

/**
 * 01.11.2021
 * 37. Spring Data Jpa Repository
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public interface AccountsRepository extends JpaRepository<Account, Long> {
    List<Account> findAllByEmailLikeIgnoreCase(String email);
}
