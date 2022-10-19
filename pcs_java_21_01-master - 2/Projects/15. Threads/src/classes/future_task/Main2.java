package classes.future_task;

import task.CsvFileProcessor;

import java.util.Scanner;
import java.util.concurrent.*;

/**
 * 16.09.2021
 * 15. Threads
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Main2 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        CsvFileProcessor processor = new CsvFileProcessor("data.csv");

        Callable<Long> byYear = () -> processor.countByPosition(0, "2018");
        Callable<Long> byAge = () -> processor.countByPosition(1, "045");
        Callable<Long> byEthic = () -> processor.countByPosition(2, "1");
        Callable<Long> bySex = () -> processor.countByPosition(3, "2");

        Future<Long> f1 = executorService.submit(byYear);
        Future<Long> f2 = executorService.submit(byEthic);
        Future<Long> f3 = executorService.submit(bySex);
        Future<Long> f4 = executorService.submit(byAge);

        Future<?>[] tasks = {f1, f2, f3, f4};

        while (true) {
            int count = 0;
            for (Future<?> future : tasks) {
                if (future.isDone()) {
                    count++;
                }
            }

            if (count == tasks.length) {
                for (Future<?> task : tasks) {
                    try {
                        System.out.println(task.get());
                    } catch (InterruptedException | ExecutionException e) {
                        throw new IllegalArgumentException();
                    }
                }
                return;
            }
        }
    }
}
