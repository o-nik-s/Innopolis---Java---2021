package example2;

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
        Runnable taskA = () -> {
            for (int i = 0; i < 1_000_000; i++) {
                System.out.println("A");
            }
        };

        Runnable taskB = () -> {
            for (int i = 0; i < 1_000_000; i++) {
                System.out.println("B");
            }
        };

        Runnable taskC = () -> {
            for (int i = 0; i < 1_000_000; i++) {
                System.out.println("C");
            }
        };

        Thread threadA = new Thread(taskA);
        Thread threadB = new Thread(taskB);
        Thread threadC = new Thread(taskC);

        threadA.start();
        threadB.start();
        threadC.start();

        // внутри main

        try {
            threadA.join();
            threadB.join();
            threadC.join();
        } catch (InterruptedException e) {
            throw new IllegalArgumentException(e);
        }

        for (int i = 0; i < 10000; i++) {
            System.out.println("Main");
        }
    }
}
