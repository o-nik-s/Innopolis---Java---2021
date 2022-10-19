import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Main2 {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, -100, 204, 105, -45, -10, 90909);
        numbers.stream()
                .filter(number -> number >= 0)
                .map(number -> {
                    String numberAsString = number.toString();
                    return numberAsString.replaceAll("0", "");
                })
                .forEach(number -> System.out.println("Число - " + number));
    }
}
