package object;

/**
 * 07.11.2021
 * 14. Object and String
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class MainEquals {
    public static void main(String[] args) {
        Human h1 = new Human(27, true);
        Human h2 = new Human(27, true);
        Human h3 = h1;

        System.out.println(h1 == h2);
        System.out.println(h1.equals(h2));
        System.out.println(h1.equals(h3));
    }
}
