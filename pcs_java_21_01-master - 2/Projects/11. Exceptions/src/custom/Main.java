package custom;

import java.util.Scanner;

/**
 * 09.09.2021
 * 11. Exceptions
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();

        if (name.length() < 2) {
            throw new BadName("Bad length");
        }
    }
}
