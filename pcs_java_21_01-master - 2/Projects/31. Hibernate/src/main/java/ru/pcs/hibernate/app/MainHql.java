package ru.pcs.hibernate.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import ru.pcs.hibernate.models.Student;

/**
 * 22.10.2021
 * 31. Hibernate
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class MainHql {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate\\hibernate.cfg.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();

        Query<Student> studentQuery = session.createQuery("select student from Student student " +
                "left join student.courses as course where course.lessons.size > 1", Student.class);

        System.out.println(studentQuery.getResultList());
        session.close();
        sessionFactory.close();
    }
}
