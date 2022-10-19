package examples;

/**
 * 08.09.2021
 * 11. Exceptions
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class MainOutOfMemoryError {
    public static void main(String[] args) {
        String names[] = new String[Integer.MAX_VALUE];
    }
}
