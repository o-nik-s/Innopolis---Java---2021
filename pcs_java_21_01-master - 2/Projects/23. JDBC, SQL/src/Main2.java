import java.sql.*;
import java.util.Scanner;

public class Main2 {

    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "qwerty007";
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/pcs_test";

    public static void main(String[] args) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new IllegalArgumentException(e);
        }

        Scanner scanner = new Scanner(System.in);
        String birthDate = scanner.nextLine();
        String sql = "select * from student where birth_date > ?::timestamp";

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, birthDate);

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    System.out.println(resultSet.getInt("id") + " " + resultSet.getString("birth_date"));
                }
            }
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
