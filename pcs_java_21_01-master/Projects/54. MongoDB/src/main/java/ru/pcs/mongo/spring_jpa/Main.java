package ru.pcs.mongo.spring_jpa;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;
import java.util.List;

/**
 * 24.11.2021
 * 54. MongoDB
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(MongoConfig.class);
        CoursesRepository coursesRepository = context.getBean(CoursesRepository.class);
        TeachersRepository teachersRepository = context.getBean(TeachersRepository.class);

//        Teacher t1 = Teacher.builder()
//                .firstName("Teacher1 - FirstName")
//                .lastName("Teacher1 - LastName")
//                .build();
//
//        Teacher t2 = Teacher.builder()
//                .firstName("Teacher2 - FirstName")
//                .lastName("Teacher2 - LastName")
//                .build();
//
//        teachersRepository.save(t1);
//        teachersRepository.save(t2);
//
//        Course course = coursesRepository.findById("619e0d8f05a5a10a47e5f9dc").orElseThrow(IllegalArgumentException::new);
//        List<Teacher> teachers = Arrays.asList(t1, t2);
//        course.setTeachers(teachers);
//        coursesRepository.save(course);
        System.out.println(coursesRepository.findAllByActiveIsTrueAndKeywordsContainsAndStudentsCountBefore("java core", 35));
    }
}
