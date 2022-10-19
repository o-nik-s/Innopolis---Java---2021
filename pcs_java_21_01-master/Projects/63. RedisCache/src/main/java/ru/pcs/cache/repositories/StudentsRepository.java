package ru.pcs.cache.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.pcs.cache.models.Student;

/**
 * 05.11.2021
 * 40. REST API
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public interface StudentsRepository extends JpaRepository<Student, Long> {
}
