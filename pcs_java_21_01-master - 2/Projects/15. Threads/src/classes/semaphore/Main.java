package classes.semaphore;

import classes.CsvFileProcessor;

import java.util.Scanner;
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
        CsvFileProcessor processor = new CsvFileProcessor("Hr5m.csv");
        Scanner scanner = new Scanner(System.in);
        int citiesCount = scanner.nextInt();
        scanner.nextLine();
        Semaphore semaphore = new Semaphore(3);

        String city = scanner.nextLine();
        int i = 0;
        while (i < citiesCount) {
            final String cityForTask = city;

            Runnable task = () -> {
                try {
                    semaphore.acquire();
                } catch (InterruptedException e) {
                    throw new IllegalStateException(e);
                }
                System.out.println(processor.countByPosition(30, cityForTask));
                semaphore.release();
            };

            new Thread(task, city).start();
            i++;
            city = scanner.nextLine();
        }
    }
}
