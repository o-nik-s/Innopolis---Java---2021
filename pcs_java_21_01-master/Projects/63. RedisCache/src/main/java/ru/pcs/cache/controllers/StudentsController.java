package ru.pcs.cache.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.pcs.cache.dto.StudentDto;
import ru.pcs.cache.services.StudentsService;

import java.util.Objects;

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

    private final CacheManager cacheManager;

    @Cacheable(value = "StudentDto", key = "#studentId")
    @GetMapping("/{student-id}")
    public StudentDto getStudent(@PathVariable("student-id") Long studentId) {
        return studentsService.getStudent(studentId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public StudentDto addStudent(@RequestBody StudentDto student) {
        return studentsService.addStudent(student);
    }

    @CachePut(value="StudentDto", key="#studentId")
    @PutMapping(value = "/{student-id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public StudentDto updateStudent(@PathVariable("student-id") Long studentId, @RequestBody StudentDto student) {
        student.setId(studentId);
        return studentsService.updateStudent(studentId, student);
    }

    @DeleteMapping(value = "/{student-id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteStudent(@PathVariable("student-id") Long studentId) {
        studentsService.deleteStudent(studentId);
        Objects.requireNonNull(cacheManager.getCache("cache")).evict(studentId);
    }
}
