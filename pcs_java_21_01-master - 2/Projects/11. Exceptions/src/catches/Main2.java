package catches;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 * 08.09.2021
 * 11. Exceptions
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Main2 {
    public static int div(int a, int b) {
        return a / b;
    }
    public static void main(String[] args) {
        Scanner scanner = null;
        while (true) {
            try {
                scanner = new Scanner(System.in);
                Random random = new Random();
                int i = random.nextInt(2);
                if (i == 0) {
                    scanner = null;
                }
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                System.out.println(div(a, b));
                break;
            } catch (InputMismatchException e) {
                System.out.println("Проблема с форматом ввода");
                scanner.nextLine();
            } catch (RuntimeException e) {
                System.out.println("Ошибка либо со сканнером, либо с математикой");
            }
        }

    }
}
