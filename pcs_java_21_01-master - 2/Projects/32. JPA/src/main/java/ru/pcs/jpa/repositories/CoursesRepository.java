package ru.pcs.jpa.repositories;

import ru.pcs.jpa.models.Course;

import java.util.List;

/**
 * 25.10.2021
 * 32. JPA
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public interface CoursesRepository extends CrudRepository<Course> {

    List<Course> findAllByLesson_name(String name);
}
