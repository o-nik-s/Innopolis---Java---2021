package task;

import intro.User;

/**
 * 31.08.2021
 * 02. OOP. Part 1
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Printer {
    public void print(int[] ages) {
        for (int i = 0; i < ages.length; i++) {
            if (ages[i] != 0) {
                System.out.printf("Возраст - %2d, встретился - %10d раз\n", i, ages[i]);
            }
        }
    }

    public void print(User[] users) {
        for (int i = 0; i < users.length; i++) {
            System.out.printf("%4d|%10s\n", users[i].getAge(), users[i].name);
        }
    }
}
