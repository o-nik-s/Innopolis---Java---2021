package catches;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 08.09.2021
 * 11. Exceptions
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Main {
    public static int div(int a, int b) {
        return a / b;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                System.out.println(div(a, b));
                break;
            } catch (ArithmeticException e) {
                System.out.println("Вы ввели ноль. Повторите ввод. Подробнее - " + e.getMessage());
            } catch (InputMismatchException e) {
                System.out.println("Вы ввели не числа, а буквы");
                scanner.nextLine();
            }
        }

    }
}
