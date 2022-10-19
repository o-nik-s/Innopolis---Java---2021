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
public class MainRelationships3 {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate\\hibernate.cfg.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Course java = session.load(Course.class, 1L);
        Course sql = session.load(Course.class, 2L);
        Student marsel = session.load(Student.class, 1L);
        Student victor = session.load(Student.class, 2L);

        marsel.getCourses().add(java);
        marsel.getCourses().add(sql);
        victor.getCourses().add(java);
        victor.getCourses().add(sql);

        // TODO: Не работает
//        java.getStudents().add(marsel);
//        java.getStudents().add(victor);
//        sql.getStudents().add(marsel);
//        sql.getStudents().add(victor);

        session.persist(java);
        session.persist(sql);
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }
}
