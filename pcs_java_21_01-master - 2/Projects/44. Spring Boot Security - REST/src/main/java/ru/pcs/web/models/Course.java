package ru.pcs.web.models;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

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
@Entity
@EqualsAndHashCode(exclude = {"lessons", "students"})
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20)
    private String title;

    @OneToMany(mappedBy = "course")
    private List<Lesson> lessons;

    @ManyToMany(mappedBy = "courses")
    private Set<Student> students;
}
