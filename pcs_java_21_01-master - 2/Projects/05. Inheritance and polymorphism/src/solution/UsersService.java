package solution;

/**
 * 03.09.2021
 * 05. Inheritance and polymorphism
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class UsersService {

    private UserDataValidator validator;

    public UsersService(UserDataValidator validator) {
        this.validator = validator;
    }

    void signUp(String email, String password) {
        if (validator.isValidEmail(email) && validator.isValidPassword(password)) {
            System.out.println("Вы успешно зарегистрированы!");
        } else {
            System.err.println("Неверный формат входных данных");
        }
    }
}
