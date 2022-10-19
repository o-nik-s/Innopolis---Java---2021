package example6;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 21.11.2021
 * 22. Threads
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Main {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();

        executorService.submit(() -> {
           for (int i = 0; i < 10000; i++) {
               System.out.println(Thread.currentThread().getName() + " A");
           }
        });

        executorService.submit(() -> {
            for (int i = 0; i < 10000; i++) {
                System.out.println(Thread.currentThread().getName() + " B");
            }
        });

        executorService.submit(() -> {
            for (int i = 0; i < 10000; i++) {
                System.out.println(Thread.currentThread().getName() + " C");
            }
        });

        executorService.submit(() -> {
            for (int i = 0; i < 10000; i++) {
                System.out.println(Thread.currentThread().getName() + " D");
            }
        });
    }
}
