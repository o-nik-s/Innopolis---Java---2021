import java.util.Scanner;

/**
 * 14.11.2021
 * 19. Exceptions
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class MainNullPointerException {
    public static void main(String[] args) {
        Scanner scanner = null;
        String line = scanner.nextLine();
    }
}
