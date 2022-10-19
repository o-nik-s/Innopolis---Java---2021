package ru.pcs.hibernate.models;

import lombok.*;

import java.util.List;

/**
 * 22.10.2021
 * 31. Hibernate
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(exclude = "students")
public class Course {
    private Long id;
    private String title;

    private List<Lesson> lessons;

    private List<Student> students;
}
