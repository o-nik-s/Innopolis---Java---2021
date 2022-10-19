package ru.pcs.repositories;

import ru.pcs.models.Student;

import java.util.List;
import java.util.Optional;

/**
 * 04.10.2021
 * 24. JDBC Repository
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public interface StudentsRepository {
    void save(Student student);

    void update(Student student);

    // TODO: реализовать самостоятельно
//    void deleteById(Long id);
//
//    void delete(Student student);

    Optional<Student> findById(Long id);

    List<Student> findAll(int page, int size);
}
