package ru.pcs.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 13.10.2021
 * 28. JUnit
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
class AccountsRepositoryJdbcImplTest {
    private AccountsRepositoryJdbcImpl accountsRepositoryJdbc;

    @BeforeEach
    public void setUp() {
        DataSource dataSource = new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .addScript("schema.sql")
                .addScript("data.sql")
                .build();

        this.accountsRepositoryJdbc = new AccountsRepositoryJdbcImpl(dataSource);
    }

    @Test
    public void test() {
        System.out.println(accountsRepositoryJdbc.findAll());
    }

}