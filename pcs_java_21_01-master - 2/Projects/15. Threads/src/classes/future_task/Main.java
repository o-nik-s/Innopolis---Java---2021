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
public class Main {
    public static void main(String[] args) {
//        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        CsvFileProcessor processor = new CsvFileProcessor("data.csv");

        Callable<Long> byYear = () -> processor.countByPosition(0, "2018");
        Callable<Long> byAge = () -> processor.countByPosition(1, "045");
        Callable<Long> byEthic = () -> processor.countByPosition(2, "1");
        Callable<Long> bySex = () -> processor.countByPosition(3, "2");

        FutureTask<Long> futureTask1 = new FutureTask<>(byYear);
        FutureTask<Long> futureTask2 = new FutureTask<>(byAge);
        FutureTask<Long> futureTask3 = new FutureTask<>(byEthic);
        FutureTask<Long> futureTask4 = new FutureTask<>(bySex);

        new Thread(futureTask1).start();
        new Thread(futureTask2).start();
        new Thread(futureTask3).start();
        new Thread(futureTask4).start();

        FutureTask[] tasks = {futureTask1, futureTask2, futureTask3, futureTask4};

        while (true) {
            int count = 0;
            for (FutureTask futureTask : tasks) {
                if (futureTask.isDone()) {
                    count++;
                }
            }

            if (count == tasks.length) {
                for (FutureTask<Long> task : tasks) {
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
