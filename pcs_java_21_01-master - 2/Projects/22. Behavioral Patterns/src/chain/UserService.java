package chain;

/**
 * 29.09.2021
 * 22. Behavioral Patterns
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class UserService {

    private final AuthenticationHandler firstHandler;

    private final UsersRepository usersRepository;

    public UserService(AuthenticationHandler firstHandler, UsersRepository usersRepository) {
        this.firstHandler = firstHandler;
        this.usersRepository = usersRepository;
    }

    public void signIn(String email, String password) {
        firstHandler.handle(email, password);
        User user = usersRepository.findByEmail(email);
        if (user != null && user.getPassword().equals("qwerty007")) {
            System.out.println("Аутентификация прошла успешно");
        } else {
            System.err.println("Пользователь не найден");
        }
    }
}
