package ru.pcs.web.repositories;

/**
 * 26.11.2021
 * 55. Spring Boot Security - REST + REDIS
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public interface BlackListRepository {
    void save(String token);

    boolean exists(String token);
}
