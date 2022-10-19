package chain;

/**
 * 29.09.2021
 * 22. Behavioral Patterns
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Main {
    public static void main(String[] args) {
        UsersRepository usersRepository = new UsersRepositoryImpl();
        NullDataValidatorAuthenticationHandler nullDataValidator = new NullDataValidatorAuthenticationHandler();
        EmailValidatorAuthenticationHandler emailValidator = new EmailValidatorAuthenticationHandler();
        PasswordValidatorAuthenticationHandler passwordValidator = new PasswordValidatorAuthenticationHandler();

        nullDataValidator.setNextHandler(emailValidator);
        emailValidator.setNextHandler(passwordValidator);

        UserService userService = new UserService(nullDataValidator, usersRepository);
        userService.signIn("sidikov@mxm.email", "qwerty007");
    }
}
