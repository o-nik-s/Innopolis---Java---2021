package ru.pcs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.pcs.models.Account;

import java.util.List;

/**
 * 01.11.2021
 * 37. Spring Data Jpa Repository
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public interface AccountsRepository extends JpaRepository<Account, Long> {
    List<Account> findAllByCars_Color(String color);

    @Query(value = "select account from Account account join fetch account.cars car where car.color = :color")
    List<Account> findAllByCarsColor(@Param("color") String color);
}
