/**
 * 27.10.2021
 * 08. OOP
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Main2 {
    public static void main(String[] args) {
        Human h1 = new Human();
        h1.setName("Виктор");
        Human h2 = h1;

        h2.setName("Марсель");
        System.out.println(h1.getName());
    }
}
