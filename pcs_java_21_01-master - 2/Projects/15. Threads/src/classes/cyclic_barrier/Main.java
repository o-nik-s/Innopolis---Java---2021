package classes.cyclic_barrier;

import classes.CsvFileProcessor;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

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
        List<Long> results = new CopyOnWriteArrayList<>();
        CyclicBarrier cyclicBarrier = new CyclicBarrier(citiesCount, () -> System.out.println(results));

        String city = scanner.nextLine();
        int i = 0;
        while (i < citiesCount) {
            final String cityForTask = city;

            Runnable task = () -> {
                long result = processor.countByPosition(30, cityForTask);
                results.add(result);
                try {
                    cyclicBarrier.await();
                } catch (Exception e) {
                    throw new IllegalArgumentException(e);
                }
                System.out.println(result);
            };

            new Thread(task, city).start();
            i++;
            city = scanner.nextLine();
        }
    }
}
