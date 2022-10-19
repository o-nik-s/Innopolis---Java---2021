package examples.streams;

import java.util.Comparator;
import java.util.stream.Stream;

/**
 * 14.09.2021
 * 14. Anonymous, Lambda, Stream API
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Main2 {
    public static void main(String[] args) {
        Stream.of("а приветик", "как дела", "что нового", "пока", "java the best")
                .filter(line -> line.indexOf(' ') != -1)
                .map(line -> line.replaceAll(" ","_"))
                .sorted(Comparator.comparingInt(String::length))
                .forEach(System.out::println);
    }
}
