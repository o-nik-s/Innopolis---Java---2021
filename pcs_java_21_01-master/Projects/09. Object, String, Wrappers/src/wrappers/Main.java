package wrappers;

/**
 * 07.09.2021
 * 09. Object, String, Wrappers
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Main {
    public static void main(String[] args) {
        Nullable<String> stringNullable = Nullable.of("Привет!");
        Nullable<Integer> integerNullable = Nullable.of(10);
        Object i = 77;
    }
}
