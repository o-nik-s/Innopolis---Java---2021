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
public class Main2 {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate\\hibernate.cfg.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        // SessionImpl
        EntityManager entityManager = sessionFactory.createEntityManager();
        // student - TRANSIENT
        Student student = Student.builder()
                .firstName("Иван")
                .lastName("Иванов")
                .build();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(student);
        // student - MANAGED
        student.setLastName("Федоров");
        transaction.commit();
        entityManager.close();
        // student - DETACHED
        student.setLastName("Крапивин");
        entityManager = sessionFactory.createEntityManager();
        transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.merge(student);
        // STUDENT - MANAGED
        transaction.commit();
        transaction = entityManager.getTransaction();
        transaction.begin();
        // marsel - MANAGED
        Student marsel = entityManager.find(Student.class, 1L);
        entityManager.remove(marsel);
        // marsel - REMOVED
        marsel.setLastName("Ситдиков");
        transaction.commit();



    }
}
