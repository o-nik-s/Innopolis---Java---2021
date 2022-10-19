package classes.exchanger;

import classes.CsvFileProcessor;
import classes.StatisticUtil;

import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.*;

/**
 * 21.09.2021
 * 15. Threads
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        Exchanger<List<String>> exchanger = new Exchanger<>();
        CsvFileProcessor processor = new CsvFileProcessor("Hr1m.csv");
        StatisticUtil statisticUtil = new StatisticUtil();

        Runnable readValuesTask = () -> processor.readValuesByPositionWithExchanger(30, exchanger, 10000);
        Callable<Set<String>> getDomainsTask = () -> statisticUtil.getEmailDomains(exchanger);

        ExecutorService service = Executors.newFixedThreadPool(2);
        service.submit(readValuesTask);
        try {
            System.out.println(service.submit(getDomainsTask).get(10, TimeUnit.SECONDS));
        } catch (TimeoutException e) {
            System.err.println("Не дождались результата");
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
        service.shutdown();
    }
}
