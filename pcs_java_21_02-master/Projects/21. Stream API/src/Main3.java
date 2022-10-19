import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * 17.11.2021
 * 21. Stream API
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Main3 {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
            reader.lines()
                    .distinct()
                    .map(line -> line.replaceAll(" ", ""))
                    .forEach(line -> System.out.println("Строка - " + line));
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
