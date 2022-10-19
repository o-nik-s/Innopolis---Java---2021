package ru.pcs.education.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.pcs.education.clients.CoursesClient;
import ru.pcs.education.clients.UsersClient;
import ru.pcs.education.dto.EducationDto;

/**
 * 17.11.2021
 * education-service
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@RestController
public class EducationController {

    @Autowired
    private CoursesClient coursesClient;

    @Autowired
    private UsersClient usersClient;

    @GetMapping("/education")
    public ResponseEntity<EducationDto> getEducation() {
        return ResponseEntity.ok(EducationDto.builder()
                .courses(coursesClient.getCourses())
                .users(usersClient.getUsers())
                .build());
    }
}
