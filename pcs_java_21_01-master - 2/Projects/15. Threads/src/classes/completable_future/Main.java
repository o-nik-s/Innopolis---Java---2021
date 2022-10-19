package classes.completable_future;

import classes.CsvFileProcessor;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.BiFunction;

/**
 * 21.09.2021
 * 15. Threads
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CsvFileProcessor csvFileProcessor = new CsvFileProcessor("Hr1m.csv");
        ExecutorService service = Executors.newFixedThreadPool(2);
        CompletableFuture<Long> future1 = CompletableFuture.supplyAsync(() -> csvFileProcessor.countByPosition(30, "Louisa"), service);
        CompletableFuture<Long> future2 = CompletableFuture.supplyAsync(() -> csvFileProcessor.countByPosition(30, "Henrico"), service);

        System.out.println(future1.thenCombine(future2, Long::sum).get());
    }
}
