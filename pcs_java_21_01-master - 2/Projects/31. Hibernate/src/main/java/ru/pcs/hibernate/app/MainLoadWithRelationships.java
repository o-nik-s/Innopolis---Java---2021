package ru.pcs.hibernate.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.pcs.hibernate.models.Student;

/**
 * 22.10.2021
 * 31. Hibernate
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class MainLoadWithRelationships {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate\\hibernate.cfg.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();

        Student student = session.load(Student.class, 1L);
        System.out.println(student);

        session.close();
        sessionFactory.close();
    }
}
