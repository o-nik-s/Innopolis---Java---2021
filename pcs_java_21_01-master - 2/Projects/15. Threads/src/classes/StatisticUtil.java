package classes;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Exchanger;
import java.util.stream.Collectors;

/**
 * 21.09.2021
 * 15. Threads
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class StatisticUtil {

    public Set<String> getEmailDomains(Exchanger<List<String>> exchanger) {
        Set<String> result = new HashSet<>();
        List<String> buffer;

        do {
            System.out.println("StatisticUtil - ожидание данных");
            try {
                buffer = exchanger.exchange(null);

                if (buffer != null) {
                    List<String> domains = buffer.stream().map(email -> email.substring(email.indexOf("@") + 1))
                            .collect(Collectors.toList());
                    System.out.println("StatisticUtil - данные получены");
                    result.addAll(domains);
                    System.out.println("StatisticUtil - данные обработаны");
                }
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
        } while (buffer != null);
        System.out.println("StatisticUtil - работа завершена");
        return result;
    }
}
