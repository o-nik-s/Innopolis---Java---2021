import java.sql.*;
import java.util.Scanner;

public class Main3 {

    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "qwerty007";
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/pcs_test";

    public static void main(String[] args) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new IllegalArgumentException(e);
        }

        String query = "select * from student where birth_date > ?::timestamp";
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             Statement statement = connection.createStatement();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            String sql = "select name, statement from pg_prepared_statements;";
            preparedStatement.setString(1, "2020-10-31");
            preparedStatement.executeQuery();
            preparedStatement.executeQuery();
            preparedStatement.executeQuery();
            preparedStatement.executeQuery();
            preparedStatement.executeQuery();
//            preparedStatement.executeQuery();
//            preparedStatement.executeQuery();
            try (ResultSet resultSet = statement.executeQuery(sql)) {
                while (resultSet.next()) {
                    System.out.println(resultSet.getString("name") + " " + resultSet.getString("statement"));
                }
            }
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
