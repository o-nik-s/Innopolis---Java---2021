package chain;

/**
 * 29.09.2021
 * 22. Behavioral Patterns
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public interface AuthenticationHandler {
    void handle(String email, String password);
    void setNextHandler(AuthenticationHandler handler);
}
