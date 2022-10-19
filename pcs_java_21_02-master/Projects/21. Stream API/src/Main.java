import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
	    List<Integer> numbers = Arrays.asList(10, -100, 204, 105, -45, -10, 90909);
        Stream<Integer> numbersStream = numbers.stream();

        Predicate<Integer> positiveNumber = number -> number >= 0;
        Function<Integer, String> numberAsStringWithoutZero = number -> {
            String numberAsString = number.toString();
            return numberAsString.replaceAll("0", "");
        };
        Consumer<String> printNumber = number -> System.out.println("Число - " + number);

        Stream<Integer> positiveNumbersStream = numbersStream.filter(positiveNumber);
        Stream<String> numbersAsStringWithoutZeroStream = positiveNumbersStream.map(numberAsStringWithoutZero);
        numbersAsStringWithoutZeroStream.forEach(printNumber);
    }
}
