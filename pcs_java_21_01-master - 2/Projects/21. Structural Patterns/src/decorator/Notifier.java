package decorator;

/**
 * 27.09.2021
 * 21. Structural Patterns
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Notifier {

    public String email;

    public Notifier(String email) {
        this.email = email;
    }

    public void notify(String message) {
        System.out.println("Оповещение по email");
    }
}
