import java.util.*;

/**
 * 13.11.2021
 * 18. Java Collection API
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class MainIterator {
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

        Iterator<Integer> numbersIterator = numbers.iterator();
        Iterator<String> linesIterator = lines.iterator();
        Iterator<String> wordsIterator = words.iterator();

        while (numbersIterator.hasNext()) {
            int value = numbersIterator.next();
            System.out.println(value);
        }

        while (linesIterator.hasNext()) {
            String line = linesIterator.next();
            System.out.println(line);
        }

        while (wordsIterator.hasNext()) {
            String word = wordsIterator.next();
            System.out.println(word);
        }
    }
}
