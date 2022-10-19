package ru.pcs.web.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.pcs.web.dto.CourseDto;
import ru.pcs.web.dto.CoursesResponse;
import ru.pcs.web.dto.StudentDto;
import ru.pcs.web.dto.StudentsResponse;
import ru.pcs.web.services.StudentsService;

import java.time.LocalDate;

/**
 * 05.11.2021
 * 40. REST API
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */ 
@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
public class StudentsController {

    private final StudentsService studentsService;

    @GetMapping("/{student-id}")
    public ResponseEntity<StudentDto> getStudent(@PathVariable("student-id") Long studentId) {
        return ResponseEntity.ok(studentsService.getStudent(studentId));
    }

    @GetMapping
    public ResponseEntity<StudentsResponse> getStudents(@RequestParam("page") int page, @RequestParam("size") int size) {
        return ResponseEntity.ok()
                .headers(httpHeaders -> httpHeaders.add("dateTime", LocalDate.now().toString()))
                .body(StudentsResponse.builder().data(studentsService.getStudents(page, size)).build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<StudentDto> addStudent(@RequestBody StudentDto student) {
        return ResponseEntity.ok(studentsService.addStudent(student));
    }

    @PutMapping(value = "/{student-id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public StudentDto updateStudent(@PathVariable("student-id") Long studentId, @RequestBody StudentDto student) {
        return studentsService.updateStudent(studentId, student);
    }

    @DeleteMapping(value = "/{student-id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteStudent(@PathVariable("student-id") Long studentId) {
        studentsService.deleteStudent(studentId);
    }

    @PostMapping(value = "/{student-id}/courses")
    @ResponseStatus(HttpStatus.CREATED)
    public CoursesResponse addCourseToStudent(@PathVariable("student-id") Long studentId,
                                                    @RequestBody CourseDto course) {
        return CoursesResponse.builder()
                .data(studentsService.addCourseToStudent(studentId, course))
                .build();
    }
}
