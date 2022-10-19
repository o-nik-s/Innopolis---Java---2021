package ru.pcs.numbers;

import java.util.Arrays;

/**
 * 13.10.2021
 * 28. JUnit
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Main {
    public static void main(String[] args) {
        NumberUtil numberUtil = new NumberUtil();
        NumbersProcessor numbersProcessor = new NumbersProcessor(numberUtil);
        System.out.println(numbersProcessor.toBooleanVector(Arrays.asList(134, 169, 13, 21, 111)));
    }
}
