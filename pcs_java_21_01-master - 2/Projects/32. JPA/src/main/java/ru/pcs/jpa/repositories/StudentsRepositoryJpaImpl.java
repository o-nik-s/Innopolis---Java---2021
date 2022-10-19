package ru.pcs.jpa.repositories;

import ru.pcs.jpa.models.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 * 25.10.2021
 * 32. JPA
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class StudentsRepositoryJpaImpl implements StudentsRepository {
    private final EntityManager entityManager;

    public StudentsRepositoryJpaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void save(Student entity) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(entity);
        transaction.commit();
    }
}
