package classes.count_down_latch;

import classes.CsvFileProcessor;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

/**
 * 21.09.2021
 * 15. Threads
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Main {
    public static void main(String[] args) {
        // Coshocton, Louisa, Henrico, Lynn, Austin, Ray, Evangeline, Cedar, San Jose
        CsvFileProcessor processor = new CsvFileProcessor("Hr1m.csv");
        Scanner scanner = new Scanner(System.in);
        int citiesCount = scanner.nextInt();
        scanner.nextLine();
        CountDownLatch countDownLatch = new CountDownLatch(5);
        String city = scanner.nextLine();
        int i = 0;
        while (i < citiesCount) {
            final String cityForTask = city;

            Runnable task = () -> {
                countDownLatch.countDown();
                try {
                    System.out.println("Задача по обработке - " + cityForTask + " получена, ушли в ожидание");
                    countDownLatch.await();
                } catch (InterruptedException e) {
                    throw new IllegalArgumentException(e);
                }
                System.out.println("Задача по " + cityForTask + " идем на выполнение");
                System.out.println(processor.countByPosition(30, cityForTask));


            };

            new Thread(task, city).start();
            i++;
            city = scanner.nextLine();
        }
    }
}
