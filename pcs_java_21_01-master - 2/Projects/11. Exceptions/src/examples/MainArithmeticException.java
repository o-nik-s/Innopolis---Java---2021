package examples;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainArithmeticException {

    public static int div(int a, int b) {
        return a / b;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        System.out.println(div(a, b));
    }
}
