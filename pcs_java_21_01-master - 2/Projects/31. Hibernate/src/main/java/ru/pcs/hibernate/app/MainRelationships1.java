package ru.pcs.hibernate.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.pcs.hibernate.models.Course;
import ru.pcs.hibernate.models.Lesson;

import java.util.ArrayList;

/**
 * 22.10.2021
 * 31. Hibernate
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class MainRelationships1 {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate\\hibernate.cfg.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Course java = Course.builder()
                .title("Java")
                .lessons(new ArrayList<>())
                .build();

        Lesson spring = Lesson.builder()
                .course(java)
                .name("Spring")
                .build();

        Lesson jvm = Lesson.builder()
                .course(java)
                .name("JVM")
                .build();

        Lesson jdbc = Lesson.builder()
                .course(java)
                .name("JDBC")
                .build();

        session.persist(java);
        session.persist(spring);
        session.persist(jvm);
        session.persist(jdbc);

        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }
}
