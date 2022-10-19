package decorator;

/**
 * 27.09.2021
 * 21. Structural Patterns
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Main {
    public static void main(String[] args) {
        Notifier notifier = new Notifier("sidikov.marsel@gmail.com");
        SmsNotifier smsNotifier = new SmsNotifier(notifier, "+7937282282");
//        TelegramNotifier telegramNotifier = new TelegramNotifier(smsNotifier, "marsel_sidikov");
        SlackNotifier slackNotifier = new SlackNotifier(smsNotifier, "maxima_marsel");

        slackNotifier.notify("Привет!");
        slackNotifier.checkAccount();
    }
}
