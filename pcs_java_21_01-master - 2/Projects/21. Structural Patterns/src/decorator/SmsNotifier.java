package decorator;

/**
 * 27.09.2021
 * 21. Structural Patterns
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class SmsNotifier extends DecoratorNotifier {

    private String phone;
    private Notifier notifier;

    public SmsNotifier(Notifier notifier, String phone) {
        super(notifier);
        this.phone = phone;
        this.notifier = notifier;
    }

    @Override
    public void notify(String message) {
        notifier.notify(message);
        System.out.println("Оповещение на телефон - " + phone + ", " + message);
    }
}
