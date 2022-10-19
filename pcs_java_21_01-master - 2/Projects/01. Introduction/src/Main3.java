/**
 * 30.08.2021
 * 01. Introduction
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Main3 {

    public static void printInRange(int from, int to) {
        for (int i = from; i <= to; i++) {
            System.out.println(i);
        }
    }

    public static void printInRange(int to) {
        for (int i = 0; i <= to; i++) {
            System.out.println(i);
        }
    }

    /**
     * Проверяет, является ли <code>number</code> простым числом
     * @param number число, которое необходимо проверить
     * @return <code>true</code> если число простое, <code>false</code> в противном случае
     */
    public static boolean isPrime(int number) {
        if (number == 2 || number == 3) {
            return true;
        }

        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static boolean isPrime(int number, boolean better) {
        if (number == 2 || number == 3) {
            return true;
        }

        if (better) {
            for (int i = 2; i * i <= number; i++) {
                if (number % i == 0) {
                    return false;
                }
            }
        } else {
            return isPrime(number);
        }

        return true;
    }

    public static int func(int number) {
        return number * number;
    }

//    public static double func(int number) {
//        return number * 0.1;
//    }

    public static void main(String[] args) {
//        boolean result = isPrime(77);
        int number = 169;
        boolean result = isPrime(number, false);
        System.out.println(result);
        result = isPrime(169, true);
        System.out.println(result);
        printInRange(5, 10);

        int x = func(10);
    }
}
