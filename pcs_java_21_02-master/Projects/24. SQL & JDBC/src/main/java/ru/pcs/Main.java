package ru.pcs;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 * 26.11.2021
 * 24. SQL & JDBC
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Main {
    public static void main(String[] args) {
        DataSource dataSource = new DriverManagerDataSource("jdbc:postgresql://localhost:5432/pcs_2",
                "postgres", "qwerty007");

        UsersRepository usersRepository = new UsersRepositoryJdbcTemplateImpl(dataSource);
        System.out.println(usersRepository.findAll());

        User user = User.builder()
                .age(10)
                .firstName("Марк")
                .lastName("Энгельсон")
                .build();

        usersRepository.save(user);

    }
}
