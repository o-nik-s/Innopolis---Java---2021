package ru.pcs.jpa.app;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
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
public class Main3 {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate\\hibernate.cfg.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        // SessionImpl
        EntityManager entityManager = sessionFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Student student = entityManager.find(Student.class, 2L);
        Student student1 = entityManager.find(Student.class, 2L);
        Student student3 = entityManager.find(Student.class, 2L);
        entityManager.refresh(student1);
        transaction.commit();
    }
}
