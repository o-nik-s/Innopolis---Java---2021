package string;

import java.util.Scanner;

/**
 * 07.11.2021
 * 14. Object and String
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class MainStringPool {
    public static void main(String[] args) {
        String s1 = "Hello!";
        String s2 = "Hello!";
        System.out.println(s1 == s2);

        Scanner scanner = new Scanner(System.in);
        String s3 = scanner.nextLine();

        System.out.println(s1 == s3);
        System.out.println(s2 == s3);
        System.out.println(s3.equals(s2));
    }
}
