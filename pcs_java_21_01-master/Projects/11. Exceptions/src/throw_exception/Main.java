package throw_exception;

import java.util.Scanner;

/**
 * 08.09.2021
 * 11. Exceptions
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Main {
    public static void validatePhone(String phone) {
        if (!phone.startsWith("+7")) {
            throw new IllegalArgumentException("Неверный формат телефона");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String phone = scanner.nextLine();
        validatePhone(phone);
    }
}
