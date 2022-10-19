package solution;

/**
 * 03.09.2021
 * 05. Inheritance and polymorphism
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class UserDataFormatValidator implements UserDataValidator {

    @Override
    public boolean isValidPassword(String password) {
        return password.length() > 7;
    }

    @Override
    public boolean isValidEmail(String email) {
        return email.contains("@");
    }
}
