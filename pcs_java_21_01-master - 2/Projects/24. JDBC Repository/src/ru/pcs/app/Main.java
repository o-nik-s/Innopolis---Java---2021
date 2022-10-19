package ru.pcs.app;

import ru.pcs.models.Student;
import ru.pcs.repositories.StudentsRepository;
import ru.pcs.repositories.StudentsRepositoryJdbcImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Optional;
import java.util.Scanner;
import java.util.function.Consumer;

public class Main {

    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "qwerty007";
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/pcs_test";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
	    try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            StudentsRepository studentsRepository = new StudentsRepositoryJdbcImpl(null);
            System.out.println(studentsRepository.findAll(1, 10));
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
