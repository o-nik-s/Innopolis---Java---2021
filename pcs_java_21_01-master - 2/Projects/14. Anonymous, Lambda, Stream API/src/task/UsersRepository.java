package task;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 14.09.2021
 * 14. Anonymous, Lambda, Stream API
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class UsersRepository {
    private String fileName;

    private List<User> users;

    public UsersRepository(String fileName) {
        this.fileName = fileName;
    }

    private final static Function<String, User> userMapFunction = line -> {
        String[] parts = line.split("\\|");

        long id = Long.parseLong(parts[0]);
        String name = parts[1];
        int age = Integer.parseInt(parts[2]);
        double height = Double.parseDouble(parts[3]);

        return new User(id, name, age, height);
    };

    public List<User> findAll() {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            return reader.lines().map(userMapFunction).collect(Collectors.toList());
        } catch (
                IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

}
