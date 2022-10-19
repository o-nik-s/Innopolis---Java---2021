package custom;

/**
 * 09.09.2021
 * 11. Exceptions
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class BadName extends RuntimeException {
    public BadName(String message) {
        super(message);
    }
}
