package ru.pcs.web.services;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.pcs.web.dto.CourseDto;
import ru.pcs.web.dto.StudentDto;
import ru.pcs.web.models.Course;
import ru.pcs.web.models.Student;
import ru.pcs.web.repositories.CoursesRepository;
import ru.pcs.web.repositories.StudentsRepository;

import java.util.List;

import static ru.pcs.web.dto.StudentDto.from;

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
    private final CoursesRepository coursesRepository;

    @Override
    public List<StudentDto> getStudents(int page, int size) {
        PageRequest request = PageRequest.of(page, size, Sort.by("id"));
        Page<Student> result = studentsRepository.findAllByIsDeletedIsNull(request);
        return from(result.getContent());
    }

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
    public StudentDto updateStudent(Long studentId, StudentDto student) {
        Student existedStudent = studentsRepository.getById(studentId);
        existedStudent.setFirstName(student.getFirstName());
        existedStudent.setLastName(student.getLastName());
        studentsRepository.save(existedStudent);
        return StudentDto.from(existedStudent);
    }

    @Override
    public void deleteStudent(Long studentId) {
        Student student = studentsRepository.getById(studentId);
        student.setIsDeleted(true);
        studentsRepository.save(student);
    }

    @Override
    public List<CourseDto> addCourseToStudent(Long studentId, CourseDto course) {
        Student student = studentsRepository.getById(studentId);
        Course existedCourse = coursesRepository.getById(course.getId());
        student.getCourses().add(existedCourse);
        studentsRepository.save(student);
        return CourseDto.from(student.getCourses());
    }

    @Override
    public StudentDto getStudent(Long studentId) {
        return from(studentsRepository.getById(studentId));
    }
}
