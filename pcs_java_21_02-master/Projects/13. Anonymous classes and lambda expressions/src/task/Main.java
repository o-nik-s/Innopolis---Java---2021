package task;

import java.util.Arrays;

/**
 * 05.11.2021
 * 13. Anonymous classes and lambda expressions
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Main {
    public static void main(String[] args) {
        int[] array = {12, 16, 782, 987, 101, 501};
        int[] a = Sequence.map(array, number -> number % 10);
        System.out.println(Arrays.toString(a));
        int[] b = Sequence.process(array, (first, second) -> first * second);
        System.out.println(Arrays.toString(b));
    }
}
