package catches;

import java.util.Stack;

/**
 * 08.09.2021
 * 11. Exceptions
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class MainStackOverflow {
    private static int f(int n) {
        return f(n - 1) * n;
    }

    public static void main(String[] args) {
        try {
            System.out.println(f(5));
        } catch (StackOverflowError e) {
            System.out.println("Переполнение стека");
        }
    }
}
