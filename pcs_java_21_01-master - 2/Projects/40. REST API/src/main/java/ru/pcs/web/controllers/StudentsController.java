package ru.pcs.web.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.pcs.web.dto.CourseDto;
import ru.pcs.web.dto.CoursesResponse;
import ru.pcs.web.dto.StudentDto;
import ru.pcs.web.dto.StudentsResponse;
import ru.pcs.web.services.StudentsService;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * 05.11.2021
 * 40. REST API
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */ 
@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentsController {

    private final StudentsService studentsService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<StudentsResponse> getStudents(@RequestParam("page") int page, @RequestParam("size") int size) {
        return ResponseEntity.ok()
                .headers(httpHeaders -> httpHeaders.add("dateTime", LocalDate.now().toString()))
                .body(StudentsResponse.builder().data(studentsService.getStudents(page, size)).build());
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public StudentDto addStudent(@RequestBody StudentDto student) {
        return studentsService.addStudent(student);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{student-id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public StudentDto updateStudent(@PathVariable("student-id") Long studentId, @RequestBody StudentDto student) {
        return studentsService.updateStudent(studentId, student);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{student-id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteStudent(@PathVariable("student-id") Long studentId) {
        studentsService.deleteStudent(studentId);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/{student-id}/courses")
    @ResponseStatus(HttpStatus.CREATED)
    public CoursesResponse addCourseToStudent(@PathVariable("student-id") Long studentId,
                                                    @RequestBody CourseDto course) {
        return CoursesResponse.builder()
                .data(studentsService.addCourseToStudent(studentId, course))
                .build();
    }
}
