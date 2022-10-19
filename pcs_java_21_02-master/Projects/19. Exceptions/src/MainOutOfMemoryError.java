/**
 * 14.11.2021
 * 19. Exceptions
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class MainOutOfMemoryError {

    public static void createArray() {
        int array[] = new int[Integer.MAX_VALUE];
    }

    public static void main(String[] args) {
        try {
            createArray();
        } catch (OutOfMemoryError e) {
            System.out.println(e.getMessage());
        }
    }
}
