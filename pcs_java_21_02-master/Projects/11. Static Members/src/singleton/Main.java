package singleton;

/**
 * 01.11.2021
 * 11. Static Members
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Main {
    public static void main(String[] args) {
        Dictionary dictionary1 = Dictionary.getInstance();
        Dictionary dictionary2 = Dictionary.getInstance();
        dictionary1.add("Привет");
        dictionary1.add("Пока!");
        dictionary1.add("Что нового?");

        System.out.println(dictionary2.complete("По"));
    }
}
