package ru.pcs.jpa.repositories;

/**
 * 25.10.2021
 * 32. JPA
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public interface CrudRepository<T> {
    void save(T entity);
}
