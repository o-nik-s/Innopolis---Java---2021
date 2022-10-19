import java.util.*;

/**
 * 13.11.2021
 * 18. Java Collection API
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class MainForeach {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(27);
        numbers.add(24);
        numbers.add(28);
        List<String> lines = new LinkedList<>();

        lines.add("Hello");
        lines.add("Marsel");
        lines.add("Java");

        Set<String> words = new HashSet<>();
        words.add("Java");
        words.add("JVM");
        words.add("JVM");
        words.add("Javac");

        for (int number : numbers) {
            System.out.println(number);
        }

        for (String line : lines) {
            System.out.println(line);
        }

        for (String word : words) {
            System.out.println(word);
        }

    }
}
