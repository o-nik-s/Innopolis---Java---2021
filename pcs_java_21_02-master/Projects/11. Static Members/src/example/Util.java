package example;

import java.util.Random;

/**
 * 01.11.2021
 * 11. Static Members
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Util {

    private static int MAX_VALUE = 10;

    public int a;

    public static int b;

    static {
        Random random = new Random();
        b = random.nextInt(100);
    }

    public static int sum(int first, int second) {
        System.out.println(b);
        return first + second;
    }
}
