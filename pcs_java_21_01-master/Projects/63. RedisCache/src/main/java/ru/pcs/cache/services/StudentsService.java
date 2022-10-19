package ru.pcs.cache.services;


import ru.pcs.cache.dto.StudentDto;

import java.util.List;

/**
 * 05.11.2021
 * 40. REST API
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public interface StudentsService {
    StudentDto addStudent(StudentDto student);

    StudentDto updateStudent(Long studentId, StudentDto student);

    void deleteStudent(Long studentId);

    StudentDto getStudent(Long studentId);
}
