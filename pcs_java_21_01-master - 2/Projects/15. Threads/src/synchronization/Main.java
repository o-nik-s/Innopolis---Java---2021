package synchronization;

/**
 * 16.09.2021
 * 15. Threads
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Main {
    public static void main(String[] args) {
        CreditCard creditCard = new CreditCard(1000);
        Human wife = new Human(creditCard, "Жена");
        Human husband = new Human(creditCard, "Муж");

        wife.start();
        husband.start();
    }
}
