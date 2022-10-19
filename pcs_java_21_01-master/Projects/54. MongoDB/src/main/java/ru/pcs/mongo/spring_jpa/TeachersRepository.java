package ru.pcs.mongo.spring_jpa;

import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * 24.11.2021
 * 54. MongoDB
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public interface TeachersRepository extends PagingAndSortingRepository<Teacher, String> {
}
