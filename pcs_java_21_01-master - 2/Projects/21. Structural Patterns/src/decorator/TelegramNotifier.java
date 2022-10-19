package decorator;

/**
 * 27.09.2021
 * 21. Structural Patterns
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class TelegramNotifier extends DecoratorNotifier {
    private String username;
    private Notifier notifier;

    public TelegramNotifier(Notifier notifier, String username) {
        super(notifier);
        this.notifier = notifier;
        this.username = username;
    }

    @Override
    public void notify(String message) {
        notifier.notify(message);
        System.out.println("Оповещение в телеграм - " + username + ", " + message);
    }
}
