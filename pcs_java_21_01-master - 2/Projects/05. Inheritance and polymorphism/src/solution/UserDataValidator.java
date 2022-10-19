package solution;

/**
 * 03.09.2021
 * 05. Inheritance and polymorphism
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public interface UserDataValidator {
    boolean isValidEmail(String email);
    boolean isValidPassword(String password);
}
