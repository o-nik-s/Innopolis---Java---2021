package ru.pcs.jpa.app;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.pcs.jpa.models.Course;
import ru.pcs.jpa.models.Lesson;
import ru.pcs.jpa.models.Student;
import ru.pcs.jpa.repositories.*;

import javax.persistence.EntityManager;
import java.util.Arrays;
import java.util.Collections;

/**
 * 25.10.2021
 * 32. JPA
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Main {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate\\hibernate.cfg.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        EntityManager entityManager = sessionFactory.createEntityManager();
        CoursesRepository coursesRepository = new CoursesRepositoryJpaImpl(entityManager);
        LessonsRepository lessonsRepository = new LessonsRepositoryJpaImpl(entityManager);
        StudentsRepository studentsRepository = new StudentsRepositoryJpaImpl(entityManager);
        /*
        Course java = Course.builder()
                .title("Java")
                .build();

        Course sql = Course.builder()
                .title("SQL")
                .build();

        coursesRepository.save(java);
        coursesRepository.save(sql);

        Lesson spring = Lesson.builder()
                .name("Spring")
                .course(java)
                .build();

        Lesson jvm = Lesson.builder()
                .name("JVM")
                .course(java)
                .build();

        Lesson jdbc = Lesson.builder()
                .name("JDBC")
                .course(java)
                .build();

        Lesson select = Lesson.builder()
                .name("select")
                .course(sql)
                .build();

        Lesson update = Lesson.builder()
                .name("update")
                .course(sql)
                .build();

        Lesson indexes = Lesson.builder()
                .name("indexes")
                .course(sql)
                .build();

        Student marsel = Student.builder()
                .firstName("Марсель")
                .lastName("Сидиков")
                .courses(Arrays.asList(java, sql))
                .build();

        Student victor = Student.builder()
                .firstName("Виктор")
                .lastName("Евлампьев")
                .courses(Arrays.asList(java, sql))
                .build();

        lessonsRepository.save(select);
        lessonsRepository.save(update);
        lessonsRepository.save(indexes);
        lessonsRepository.save(spring);

        lessonsRepository.save(jvm);
        lessonsRepository.save(jdbc);

        studentsRepository.save(marsel);
        studentsRepository.save(victor);
        */

        System.out.println(coursesRepository.findAllByLesson_name("Spring"));

    }
}
