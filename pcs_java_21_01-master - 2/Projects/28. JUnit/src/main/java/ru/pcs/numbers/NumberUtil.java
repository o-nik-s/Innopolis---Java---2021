package ru.pcs.numbers;

/**
 * 13.10.2021
 * 28. JUnit
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class NumberUtil implements NumberToBooleanMapper {
    // 31
    // 2, 3, 4, 5
    public boolean isPrime(int number) {

        if (number == 0 || number == 1) {
            throw new IncorrectNumberException();
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

    // 9, 12 -> 3
    public int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }

        return a;
    }

    @Override
    public boolean map(int number) {
        return isPrime(number);
    }
}
