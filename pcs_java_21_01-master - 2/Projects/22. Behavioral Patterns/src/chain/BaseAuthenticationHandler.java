package chain;

/**
 * 29.09.2021
 * 22. Behavioral Patterns
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public abstract class BaseAuthenticationHandler implements AuthenticationHandler {
    protected AuthenticationHandler next;

    @Override
    public void setNextHandler(AuthenticationHandler handler) {
        this.next = handler;
    }

    protected void nextHandler(String email, String password) {
        if (next != null) {
            next.handle(email, password);
        }
    }
}
