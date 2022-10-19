package ru.pcs.jpa.app;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.pcs.jpa.models.Course;
import ru.pcs.jpa.models.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 * 27.10.2021
 * 32. JPA
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Main4 {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate\\hibernate.cfg.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        // SessionImpl
        EntityManager entityManager = sessionFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Student student = entityManager.find(Student.class, 2L);
        Course course = entityManager.getReference(Course.class, 2L);
        student.getCourses().remove(course);
        transaction.commit();
    }
}
