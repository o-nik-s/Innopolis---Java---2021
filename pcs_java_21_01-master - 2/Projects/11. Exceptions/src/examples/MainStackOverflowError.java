package examples;

/**
 * 08.09.2021
 * 11. Exceptions
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class MainStackOverflowError {
    private static int f(int n) {
//        if (n == 0) {
//            return 1;
//        } else {
//            return f(n - 1) * n;
//        }
        return f(n - 1) * n;
    }

    public static void main(String[] args) {
        System.out.println(f(5));
    }
}
