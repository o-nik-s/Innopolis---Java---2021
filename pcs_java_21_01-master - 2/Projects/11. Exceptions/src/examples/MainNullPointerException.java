package examples;

import java.util.Scanner;

/**
 * 08.09.2021
 * 11. Exceptions
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class MainNullPointerException {
    public static void main(String[] args) {
        Scanner scanner = null;
        scanner.nextLine();
    }
}
