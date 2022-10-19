package task;

import task.executors.TaskExecutor;
import task.executors.TaskExecutorThreadPerTask;
import task.executors.TaskExecutorWorkerThread;

import java.util.Scanner;

/**
 * 16.09.2021
 * 15. Threads
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        CsvFileProcessor processor = new CsvFileProcessor("data.csv");
        TaskExecutor taskExecutor = new TaskExecutorWorkerThread();
        taskExecutor.submit(() -> System.out.println(processor.countByPosition(0, "2018")));
        scanner.nextLine();
        taskExecutor.submit(() -> System.out.println(processor.countByPosition(1, "045")));
        scanner.nextLine();
        taskExecutor.submit(() -> System.out.println(processor.countByPosition(2, "1")));
        scanner.nextLine();
        taskExecutor.submit(() -> System.out.println(processor.countByPosition(3, "2")));

    }
}
