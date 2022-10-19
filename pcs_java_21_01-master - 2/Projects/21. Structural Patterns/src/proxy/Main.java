package proxy;

/**
 * 27.09.2021
 * 21. Structural Patterns
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Main {
    public static void main(String[] args) {
        UserService userService = new UserService();
        UserServiceProxy proxy = new UserServiceProxy(userService);
        proxy.setBefore(()-> System.out.println("Происходит запрос на регистрацию"));
        proxy.setAfter(() -> System.out.println("Пользователю ушло письмо на почту"));
        proxy.setInstead(() -> System.out.println("Регистрация не происходит. Фейковая реализация"));
        proxy.signUp("sidikov.marsel@gmail.com", "qwerty007");
    }
}
