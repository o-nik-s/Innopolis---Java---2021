package ru.pcs.app;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.pcs.emulator.Clients;
import ru.pcs.models.Student;
import ru.pcs.repositories.StudentsRepository;
import ru.pcs.repositories.StudentsRepositoryJdbcImpl;

import java.time.LocalDateTime;

/**
 * 04.10.2021
 * 24. JDBC Repository
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Main {

    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "qwerty007";
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/pcs_test";

    public static final String ORG_POSTGRESQL_DRIVER = "org.postgresql.Driver";

    public static void main(String[] args) {
        HikariConfig config = new HikariConfig();
        config.setUsername(DB_USER);
        config.setPassword(DB_PASSWORD);
        config.setDriverClassName(ORG_POSTGRESQL_DRIVER);
        config.setJdbcUrl(DB_URL);
        config.setMaximumPoolSize(20);
        HikariDataSource dataSource = new HikariDataSource(config);
        StudentsRepository studentsRepository = new StudentsRepositoryJdbcImpl(dataSource);

        Clients clients = new Clients();


        studentsRepository.save(new Student(LocalDateTime.now(), 30));
        for (int i = 0; i < 180; i++) {
            final int finalI = i;
            clients.newClient(() -> System.out.println(studentsRepository.findAll(finalI, 100)));
        }
        clients.run();
        clients.stop();
    }
}
