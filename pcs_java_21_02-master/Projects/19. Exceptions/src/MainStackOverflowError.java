/**
 * 14.11.2021
 * 19. Exceptions
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class MainStackOverflowError {
    // n! = 1 * 2 * 3 ... * n
    // 0! = 1
    // 5! = 1 * 2 * 3 * 4 * 5
    // 4! = 1 * 2 * 3 * 4
    // 5! = (1 * 2 * 3 * 4) * 5 = 4! * 5
    // n! = (n - 1)! * n
    public static int f(int n) {
//        if (n == 0) {
//            return 1;
//        }
        return f(n - 1) * n;
    }

    public static void main(String[] args) {
        System.out.println(f(5));
    }
}
