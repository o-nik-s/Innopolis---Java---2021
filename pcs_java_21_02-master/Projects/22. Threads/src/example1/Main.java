package example1;

import java.util.Scanner;

/**
 * 20.11.2021
 * 22. Threads
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();

        AnotherThread anotherThread = new AnotherThread("another");

        anotherThread.start();
        for (int i = 0; i < 1000000; i++) {
            System.out.println(Thread.currentThread().getName());
        }
        int i = 10;

    }
}
