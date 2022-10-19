package ru.pcs.jpa.app;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.pcs.jpa.dto.CourseInfo;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

/**
 * 27.10.2021
 * 32. JPA
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Main5 {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate\\hibernate.cfg.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        // SessionImpl
        EntityManager entityManager = sessionFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        TypedQuery<CourseInfo> query = entityManager.createQuery("select new ru.pcs.jpa.dto.CourseInfo(course.title, " +
                "course.lessons.size, course.students.size) from Course course where course.id = 1", CourseInfo.class);
        CourseInfo courseInfo = query.getSingleResult();
        System.out.println(courseInfo);
        transaction.commit();
    }
}
