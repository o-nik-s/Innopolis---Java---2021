package example3;

import java.util.Random;
import java.util.Scanner;

/**
 * 20.11.2021
 * 22. Threads
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Main {

    public static int array[];

    public static int sums[];

    public static int sum;

    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        int numbersCount = scanner.nextInt();
        int threadsCount = scanner.nextInt();

        array = new int[numbersCount];
        sums = new int[threadsCount];

        // заполняем случайными числами
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100);
        }

        int realSum = 0;

        for (int i = 0; i < array.length; i++) {
            realSum += array[i];
        }

        // для 2 000 000 -> 98996497, 98913187
        System.out.println(realSum);

        // TODO: реализовать работу с потоками

        int byThreadSum = 0;

        for (int i = 0; i < threadsCount; i++) {
            byThreadSum += sums[i];
        }

        System.out.println(byThreadSum);
    }
}
