package example5;

/**
 * 21.11.2021
 * 22. Threads
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Main {
    public static void main(String[] args) {
        CreditCard card = new CreditCard(1000);
        Human wife = new Human(card, "Жена");
        Human husband = new Human(card, "Муж");

        wife.start();
        husband.start();
    }
}
