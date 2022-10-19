package decorator;

/**
 * 27.09.2021
 * 21. Structural Patterns
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class SlackNotifier extends DecoratorNotifier {

    private String username;
    private Notifier notifier;

    public SlackNotifier(Notifier notifier, String username) {
        super(notifier);
        this.notifier = notifier;
        this.username = username;
    }

    @Override
    public void notify(String message) {
        notifier.notify(message);
        System.out.println("Оповещение в Slack - " + username + ", " + message);
    }

    public void checkAccount() {
        System.out.println("Проверка - " + username);
    }
}
