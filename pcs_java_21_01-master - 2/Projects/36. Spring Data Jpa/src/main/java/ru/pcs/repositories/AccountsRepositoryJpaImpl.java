package ru.pcs.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.pcs.models.Account;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

/**
 * 01.11.2021
 * 36. Spring Data Jpa
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@Repository
public class AccountsRepositoryJpaImpl implements AccountsRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public void save(Account student) {
        entityManager.persist(student);
    }

    @Override
    public List<Account> findAllByEmail(String email) {
        return null;
    }

    @Override
    public Optional<Account> findById(Long id) {
        return Optional.empty();
    }
}
