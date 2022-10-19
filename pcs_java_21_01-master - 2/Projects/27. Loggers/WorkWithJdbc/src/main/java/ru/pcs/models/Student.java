package ru.pcs.models;

import java.time.LocalDateTime;
import java.util.StringJoiner;

/**
 * 04.10.2021
 * 24. JDBC Repository
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Student {
    private Long id;

    private LocalDateTime birthDate;

    private Integer age;

    public Student(Long id, LocalDateTime birthDate, Integer age) {
        this.id = id;
        this.birthDate = birthDate;
        this.age = age;
    }

    public Student(LocalDateTime birthDate, Integer age) {
        this.birthDate = birthDate;
        this.age = age;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setBirthDate(LocalDateTime birthDate) {
        this.birthDate = birthDate;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getBirthDate() {
        return birthDate;
    }

    public Integer getAge() {
        return age;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Student.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("birthDate=" + birthDate)
                .add("age=" + age)
                .toString();
    }
}
