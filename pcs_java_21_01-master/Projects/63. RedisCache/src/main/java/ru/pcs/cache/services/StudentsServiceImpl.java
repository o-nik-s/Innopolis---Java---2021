package ru.pcs.cache.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.pcs.cache.dto.StudentDto;
import ru.pcs.cache.models.Student;
import ru.pcs.cache.repositories.StudentsRepository;


/**
 * 05.11.2021
 * 40. REST API
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@Service
@RequiredArgsConstructor
public class StudentsServiceImpl implements StudentsService {

    private final StudentsRepository studentsRepository;

    @Override
    public StudentDto addStudent(StudentDto student) {
        Student newStudent = Student.builder()
                .firstName(student.getFirstName())
                .lastName(student.getLastName())
                .build();

        studentsRepository.save(newStudent);

        return StudentDto.from(newStudent);
    }

    @Override
    public void deleteStudent(Long studentId) {
        Student student = studentsRepository.getById(studentId);
        student.setIsDeleted(true);
        studentsRepository.save(student);
    }

    @Override
    public StudentDto updateStudent(Long studentId, StudentDto student) {
        Student existedStudent = studentsRepository.getById(studentId);
        existedStudent.setFirstName(student.getFirstName());
        existedStudent.setLastName(student.getLastName());
        studentsRepository.save(existedStudent);
        return StudentDto.from(existedStudent);
    }

    @Override
    public StudentDto getStudent(Long studentId) {
        return StudentDto.from(studentsRepository.getById(studentId));
    }
}
