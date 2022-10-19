package ru.pcs.repositories;

import ru.pcs.models.Account;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

/**
 * 04.10.2021
 * 24. JDBC Repository
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class AccountsRepositoryJdbcImpl implements AccountsRepository {

    //language=SQL
    private static final String SQL_INSERT = "insert into account(email, password) " +
            "values (?, ?)";

    private final DataSource dataSource;

    private static final Function<ResultSet, Account> studentMapper = row -> {
        try {
            return Account.builder()
                    .id(row.getLong("id"))
                    .password(row.getString("password"))
                    .email(row.getString("email"))
                    .build();
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    };

    public AccountsRepositoryJdbcImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void save(Account account) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS)) {

            statement.setString(1, account.getEmail());
            statement.setString(2, account.getPassword());

            int affectedRows = statement.executeUpdate();

            if (affectedRows != 1) {
                throw new SQLException("Can't insert account");
            }

            ResultSet generatedKeys = statement.getGeneratedKeys();

            if (generatedKeys.next()) {
                account.setId(generatedKeys.getLong("id"));
            } else {
                throw new SQLException("Can't get id");
            }

        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
