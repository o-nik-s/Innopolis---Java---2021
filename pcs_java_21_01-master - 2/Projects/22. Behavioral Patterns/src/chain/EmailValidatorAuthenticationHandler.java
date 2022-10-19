package chain;

/**
 * 29.09.2021
 * 22. Behavioral Patterns
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class EmailValidatorAuthenticationHandler extends BaseAuthenticationHandler {

    @Override
    public void handle(String email, String password) {
        if (email.contains("@")) {
            nextHandler(email, password);
        } else {
            throw new IllegalArgumentException("Wrong email format");
        }
    }
}
