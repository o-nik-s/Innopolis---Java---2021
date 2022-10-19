package builder;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 27.09.2021
 * 20. Creational Patterns
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Main {
    public static void main(String[] args) {
//        User.Builder builder1 = User.builder();
//        User.Builder builder2 = builder1.firstName("Марсель");
//        User.Builder builder3 = builder2.lastName("Сидиков");
//        User.Builder builder4 = builder3.height(1.85);

//        User.Builder builder1 = User.builder()
//                .firstName("Марсель")
//                .lastName("Сидиков")
//                .height(1.85);

        User user = User.builder()
                .firstName("Марсель")
                .lastName("Сидиков")
                .height(1.85)
                .build();

        System.out.println(user);

        StringBuilder builder = new StringBuilder();
        builder.append("Привет").append("Как дела").append("Что нового?");
        System.out.println(Stream.of("Hello", "Bye", "Marsel")
                .filter(word -> word.length() > 2)
                .map(String::length)
                .distinct()
                .collect(Collectors.toList()));
    }
}
