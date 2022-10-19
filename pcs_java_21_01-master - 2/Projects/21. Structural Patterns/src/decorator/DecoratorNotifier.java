package decorator;

/**
 * 27.09.2021
 * 21. Structural Patterns
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class DecoratorNotifier extends Notifier {

    private final Notifier notifier;

    public DecoratorNotifier(Notifier notifier) {
        super(notifier.email);
        this.notifier = notifier;
    }

    @Override
    public void notify(String message) {
        super.notify(message);
    }
}
