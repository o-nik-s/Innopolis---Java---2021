package ru.pcs.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import ru.pcs.models.Account;

import javax.sql.DataSource;
import java.sql.*;
import java.util.*;

/**
 * 04.10.2021
 * 24. JDBC Repository
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@Repository
public class AccountsRepositoryJdbcTemplateImpl implements AccountsRepository {

    //language=SQL
    private static final String SQL_INSERT = "insert into account(email, password) " +
            "values (:email, :password)";

    //language=SQL
    private static final String SQL_SELECT_BY_EMAIL = "select * from account where email = :email";

    //language=SQL
    private static final String SQL_SELECT_BY_ID = "select * from account where id = :id";

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public AccountsRepositoryJdbcTemplateImpl(DataSource dataSource) {
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    private static final RowMapper<Account> accountMapper = (row, rowNumber) -> {
        Integer age = row.getObject("age", Integer.class);
        return Account.builder()
                .id(row.getLong("id"))
                .password(row.getString("password"))
                .email(row.getString("email"))
                .age(age)
                .build();
    };

    @Override
    public void save(Account account) {
        Map<String, Object> params = new HashMap<>();
        params.put("email", account.getEmail());
        params.put("password", account.getPassword());

        SqlParameterSource parameterSource = new MapSqlParameterSource(params);

        KeyHolder keyHolder = new GeneratedKeyHolder();
        namedParameterJdbcTemplate.update(SQL_INSERT, parameterSource, keyHolder, new String[]{"id"});
        account.setId(keyHolder.getKeyAs(Long.class));
    }

    @Override
    public List<Account> findAllByEmail(String email) {
        return namedParameterJdbcTemplate.query(SQL_SELECT_BY_EMAIL,
                Collections.singletonMap("email", email), accountMapper);
    }

    @Override
    public Optional<Account> findById(Long id) {
        try {
            return Optional.of(namedParameterJdbcTemplate.queryForObject(SQL_SELECT_BY_ID,
                    Collections.singletonMap("id", id),
                    accountMapper));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }
}
