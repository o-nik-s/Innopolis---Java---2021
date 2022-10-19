package ru.pcs;

/**
 * 28.11.2021
 * 25. JUnit
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class NumbersUtil {
    // простое число, это число, которое делится на само себя и на единицу и все :)

    // 31 -> 2, 3, 4, 5, 6, 7, ...., 30
    // 31 -> 2, 3, 4, ..., 15
    // 31 -> 2, 3, 4, 5
    public boolean isPrime(int number) {

        if (number == 0 || number == 1) {
            throw new IllegalArgumentException();
        }

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

    public int sum(int a, int b) {
        return a + b;
    }

    /*
    нод(18, 12) -> 6
    нод(9, 12) -> 3
    нод(64, 48) -> 16

    Предусмотреть, когда на вход "некрсивые числа", отрицательные числа -> исключения
     */
    public int gcd(int a, int b) {
        return -1;
    }
}
