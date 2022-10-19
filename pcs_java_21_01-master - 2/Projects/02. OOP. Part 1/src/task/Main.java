package task;

import intro.User;

import java.util.Random;
import java.util.Scanner;

/**
 * 31.08.2021
 * 02. OOP. Part 1
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Main {

    public static void main(String[] args) {
        Statistic statistic = new Statistic();
        Printer printer = new Printer();
        UsersGenerator generator = new UsersGenerator();

        Scanner scanner = new Scanner(System.in);

        int count = scanner.nextInt();
        int maxAge = scanner.nextInt();

        User[] users = generator.generate(count, maxAge);

        printer.print(users);

//        users[5].age = -10;

        users[5].setAge(-10);

        int[] ages = statistic.calcAges(maxAge, users);

        System.out.println("----");

        printer.print(ages);
    }
}
