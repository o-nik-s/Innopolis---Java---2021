import java.util.Scanner;

public class MainArithmeticException {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Введите первое число:");
            int first = scanner.nextInt();
            System.out.println("Введите второе число:");
            int second = scanner.nextInt();

            try {
                int result = first / second;
                System.out.println(first + "/" + second + "=" + result);
            } catch (ArithmeticException e) {
                System.out.println("Ошибка - " + e.getMessage());
            }
        }
    }
}
