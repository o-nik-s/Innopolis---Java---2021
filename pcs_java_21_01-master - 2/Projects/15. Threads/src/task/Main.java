package task;

import task.executors.TaskExecutor;
import task.executors.TaskExecutorThreadPerTask;

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
        CsvFileProcessor processor = new CsvFileProcessor("data.csv");
        TaskExecutor taskExecutor = new TaskExecutorThreadPerTask();
        taskExecutor.submit(() -> System.out.println(processor.countByPosition(0, "2018")));
        taskExecutor.submit(() -> System.out.println(processor.countByPosition(1, "045")));
        taskExecutor.submit(() -> System.out.println(processor.countByPosition(2, "1")));
        taskExecutor.submit(() -> System.out.println(processor.countByPosition(3, "2")));
        processor.countByPosition(0, "2018");
        processor.countByPosition(1, "045");
        processor.countByPosition(2, "1");
        processor.countByPosition(3, "2");

    }
}
