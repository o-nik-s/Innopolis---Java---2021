package ru.pcs.hibernate.models;

import lombok.*;

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
@ToString(exclude = "course")
public class Lesson {
    private Long id;
    private String name;

    private Course course;
}
