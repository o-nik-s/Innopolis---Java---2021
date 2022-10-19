package ru.pcs.web.services;

import ru.pcs.web.dto.CourseDto;
import ru.pcs.web.dto.StudentDto;

import java.util.List;

/**
 * 05.11.2021
 * 40. REST API
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public interface StudentsService {
    List<StudentDto> getStudents(int page, int size);

    StudentDto addStudent(StudentDto student);

    StudentDto updateStudent(Long studentId, StudentDto student);

    void deleteStudent(Long studentId);

    List<CourseDto> addCourseToStudent(Long studentId, CourseDto course);

    StudentDto getStudent(Long studentId);
}
