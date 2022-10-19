package examples.functional_interfaces;

import java.util.Arrays;
import java.util.List;

/**
 * 14.09.2021
 * 14. Anonymous, Lambda, Stream API
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Main {
    public static void main(String[] args) {
        List<String> lines = Arrays.asList("Привет", "как дела", "что нового", "пока");
        Sequence<String> sequence = new Sequence<>(lines);
        List<String> filtered = sequence.filter(line -> line.indexOf(' ') != -1);
        System.out.println(filtered);
        List<Integer> result = sequence.map(line -> line.indexOf('о'));
        System.out.println(result);
        sequence.forEach(System.out::println);
    }
}
