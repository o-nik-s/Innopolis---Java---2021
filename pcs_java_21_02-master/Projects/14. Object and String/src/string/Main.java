package string;

/**
 * 07.11.2021
 * 14. Object and String
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Main {
    public static void main(String[] args) {
        String s1 = "Hello!";
        String s2 = s1.replace("l", "o");
        System.out.println(s2);
        System.out.println(s1 == s2);
    }
}
