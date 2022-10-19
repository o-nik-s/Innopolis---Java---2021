package facade;

/**
 * 27.09.2021
 * 21. Structural Patterns
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public interface EmailSender {
    void sendConfirmMessage(String email, String message);
}
