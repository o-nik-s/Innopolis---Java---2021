package task;

import intro.User;

import java.util.Random;

/**
 * 31.08.2021
 * 02. OOP. Part 1
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class UsersGenerator {
    public User[] generate(int count, int maxAge) {

        Random random = new Random();

        User[] users = new User[count];

        for (int i = 0; i < users.length; i++) {
            int randomAge = random.nextInt(maxAge);
            users[i] = new User(randomAge, "User" + i);
        }

        return users;
    }
}
