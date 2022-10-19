package ru.pcs.repositories;

import ru.pcs.models.Student;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
public class StudentsRepositoryJdbcImpl implements StudentsRepository {

    //language=SQL
    private static final String SQL_SELECT_ALL = "select id, birth_date, age from student order by id limit ? offset ?;";

    //language=SQL
    private static final String SQL_SELECT_BY_ID = "select id, birth_date, age from student where id = ?";

    //language=SQL
    private static final String SQL_INSERT = "insert into student(birth_date, age) values (?, ?)";

    //language=SQL
    private static final String SQL_UPDATE = "update student set birth_date = ?, age = ? where id = ?;";

    private final DataSource dataSource;

    private static final Function<ResultSet, Student> studentMapper = resultSet -> {
        try {
            Long id = resultSet.getLong("id");
            Timestamp timestamp = resultSet.getTimestamp("birth_date");
            LocalDateTime birthDate = timestamp.toLocalDateTime();
            Integer age = resultSet.getObject("age", Integer.class);
            return new Student(id, birthDate, age);
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    };

    public StudentsRepositoryJdbcImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void save(Student student) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS)) {
            statement.setTimestamp(1, Timestamp.valueOf(student.getBirthDate()));
            statement.setInt(2, student.getAge());
            int affectedRows = statement.executeUpdate();

            if (affectedRows != 1) {
                throw new SQLException("Can't insert student");
            }

            ResultSet generatedKeys = statement.getGeneratedKeys();

            if (generatedKeys.next()) {
                student.setId(generatedKeys.getLong("id"));
            } else {
                throw new SQLException("Can't get id");
            }

        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public void update(Student student) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_UPDATE)) {
            statement.setTimestamp(1, Timestamp.valueOf(student.getBirthDate()));
            statement.setInt(2, student.getAge());
            statement.setLong(3, student.getId());

            int affectedRows = statement.executeUpdate();

            if (affectedRows != 1) {
                throw new SQLException("Can't update student");
            }
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public Optional<Student> findById(Long studentId) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_SELECT_BY_ID)) {
            statement.setLong(1, studentId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return Optional.of(studentMapper.apply(resultSet));
                }
                return Optional.empty();
            }
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public List<Student> findAll(int page, int size) {
        List<Student> students = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_SELECT_ALL)) {
            statement.setInt(1, size);
            statement.setInt(2, page * size);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    students.add(studentMapper.apply(resultSet));
                }
                return students;
            }
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
