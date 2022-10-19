package runnable;

import java.util.Scanner;

/**
 * 16.09.2021
 * 15. Threads
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        Object object = new Object();
        Runnable task = () -> {
            for (int i = 0; i < 100_000; i++) {
                synchronized (object) {
                    try {
                        Thread.sleep(1);
                        System.out.println("A");
                        Thread.sleep(1);
                        System.out.println("B");
                        Thread.sleep(1);
                        System.out.println("C");
                        Thread.sleep(1);
                        System.out.println("D");
                        Thread.sleep(1);
                        System.out.println("E");
                        Thread.sleep(1);
                        System.out.println("F");
                    } catch (InterruptedException e) {
                        throw new IllegalArgumentException(e);
                    }
                }
            }
        };

        Runnable task2 = () -> {
            for (int i = 0; i < 100_000; i++) {
                synchronized (object) {
                    try {
                        Thread.sleep(1);
                        System.out.println("1");
                        Thread.sleep(1);
                        System.out.println("2");
                        Thread.sleep(1);
                        System.out.println("3");
                        Thread.sleep(1);
                        System.out.println("4");
                        Thread.sleep(1);
                        System.out.println("5");
                        Thread.sleep(1);
                        System.out.println("6");
                    } catch (InterruptedException e) {
                        throw new IllegalArgumentException(e);
                    }
                }
            }
        };

        Thread thread = new Thread(task);
        Thread thread2 = new Thread(task2);
        thread.start();
        thread2.start();
    }
}
