package ru.pcs.app;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import ru.pcs.repositories.StudentsRepository;
import ru.pcs.repositories.StudentsRepositoryJdbcImpl;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 04.10.2021
 * 24. JDBC Repository
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Main2 {

    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "qwerty007";
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/pcs_test";

    private static final int MAX_CLIENTS_COUNT = 300;
    public static final String ORG_POSTGRESQL_DRIVER = "org.postgresql.Driver";

    public static void main(String[] args) {
//        DataSource dataSource = new SingleConnectionDataSource(DB_USER, DB_PASSWORD, DB_URL);
//        DataSource dataSource = new OnePerQueryDataSource(DB_USER, DB_PASSWORD, DB_URL);

        HikariConfig config = new HikariConfig();
        config.setUsername(DB_USER);
        config.setPassword(DB_PASSWORD);
        config.setDriverClassName(ORG_POSTGRESQL_DRIVER);
        config.setJdbcUrl(DB_URL);
        config.setMaximumPoolSize(20);
        HikariDataSource dataSource = new HikariDataSource(config);
        StudentsRepository studentsRepository = new StudentsRepositoryJdbcImpl(dataSource);

        ExecutorService service = Executors.newFixedThreadPool(MAX_CLIENTS_COUNT);

        for (int clientNumber = 0; clientNumber < MAX_CLIENTS_COUNT; clientNumber++) {
            service.submit(() -> {
                for (int i = 0; i < 180; i++) {
                    try {
                        System.out.println(studentsRepository.findAll(i, 100));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }

        service.shutdown();

    }
}
