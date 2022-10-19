package ru.pcs.hibernate.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.pcs.hibernate.models.Student;

import java.util.Scanner;

/**
 * 22.10.2021
 * 31. Hibernate
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class MainPersistVsSave {

    private static final Logger logger = LoggerFactory.getLogger(MainPersistVsSave.class);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Configuration configuration = new Configuration();
        configuration.configure("hibernate\\hibernate.cfg.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        System.out.println("Start create student...");
        String firstName = scanner.nextLine();
        Student student = Student.builder()
                .firstName(firstName)
                .build();
        session.persist(student);
        System.out.println("Student created...");
        String lastName = scanner.nextLine();
        student.setLastName(lastName);
        session.getTransaction().commit();
        sessionFactory.close();
    }
}
