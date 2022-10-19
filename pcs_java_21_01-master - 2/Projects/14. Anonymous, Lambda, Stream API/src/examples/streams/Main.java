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
public class Main {
    public static void main(String[] args) {
        Stream<String> stringsStream = Stream.of("а приветик", "как дела", "что нового", "пока", "java the best");
        Stream<String> filteredStream = stringsStream.filter(line -> line.indexOf(' ') != -1);
        Stream<String> processedStream = filteredStream.map(line -> line.replaceAll(" ","_"));
        Stream<String> sorted = processedStream.sorted(Comparator.comparingInt(String::length));
        sorted.forEach(System.out::println);

    }
}
