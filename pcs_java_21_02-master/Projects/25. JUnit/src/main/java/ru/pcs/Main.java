package ru.pcs;

/**
 * 28.11.2021
 * 25. JUnit
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Main {
    public static void main(String[] args) {
        NumbersUtil numbersUtil = new NumbersUtil();

        System.out.println(Math.sqrt(31));
        System.out.println(numbersUtil.isPrime(13)); // true
        System.out.println(numbersUtil.isPrime(31)); // true
        System.out.println(numbersUtil.isPrime(169)); // false -> true!!!
        System.out.println(numbersUtil.isPrime(172)); // false
        System.out.println(numbersUtil.isPrime(2)); // true
        System.out.println(numbersUtil.isPrime(3)); // true
    }
}
