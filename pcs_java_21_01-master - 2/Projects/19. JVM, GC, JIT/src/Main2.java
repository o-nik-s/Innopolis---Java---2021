import java.util.Scanner;

/**
 * 24.09.2021
 * 19. JVM, GC, JIT
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Main2 {

    public static boolean isPrime(int number) {
        if (number == 2 || number == 3) {
            return true;
        }

        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            int number = scanner.nextInt();

            for (int i = 0; i < 1000; i++) {
                boolean isPrime = isPrime(number);
            }
        }
    }
}
