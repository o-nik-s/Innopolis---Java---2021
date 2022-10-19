package solution;

/**
 * 03.09.2021
 * 05. Inheritance and polymorphism
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Main {
    public static void main(String[] args) {
        UserDataValidator validator = new UserDataFormatValidator();
        UsersService usersService = new UsersService(validator);

        usersService.signUp("sidikov.marselgmail.com", "alphabeta");
    }
}
