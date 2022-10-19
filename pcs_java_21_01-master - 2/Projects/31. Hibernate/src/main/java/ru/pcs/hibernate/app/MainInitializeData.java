package ru.pcs.hibernate.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.pcs.hibernate.models.Course;
import ru.pcs.hibernate.models.Lesson;
import ru.pcs.hibernate.models.Student;

import java.util.Arrays;

/**
 * 22.10.2021
 * 31. Hibernate
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class MainInitializeData {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate\\hibernate.cfg.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Lesson spring = Lesson.builder()
                .name("Spring")
                .build();

        Lesson jvm = Lesson.builder()
                .name("JVM")
                .build();

        Lesson jdbc = Lesson.builder()
                .name("JDBC")
                .build();

        Lesson select = Lesson.builder()
                .name("select")
                .build();

        Lesson update = Lesson.builder()
                .name("update")
                .build();

        Lesson indexes = Lesson.builder()
                .name("indexes")
                .build();

        session.persist(select);
        session.persist(update);
        session.persist(indexes);

        session.persist(spring);
        session.persist(jvm);
        session.persist(jdbc);

        Course java = Course.builder()
                .title("Java")
                .lessons(Arrays.asList(spring, jvm, jdbc))
                .build();

        Course sql = Course.builder()
                .title("SQL")
                .lessons(Arrays.asList(select, update, indexes))
                .build();

        session.persist(java);
        session.persist(sql);

        Student marsel = Student.builder()
                .firstName("Марсель")
                .lastName("Сидиков")
                .build();

        Student victor = Student.builder()
                .firstName("Виктор")
                .lastName("Евлампьев")
                .build();

        session.persist(marsel);
        session.persist(victor);

        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }
}
