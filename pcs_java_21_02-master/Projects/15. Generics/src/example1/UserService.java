package example1;

/**
 * 08.11.2021
 * 15. Generics
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class UserService {
    public Nullable<User> signIn(String email, String password) {
        if (email.equals("sidikov.marsel@gmail.com") && password.equals("qwerty007")) {
            User user =  new User("Марсель", "Сидиков");
            return Nullable.of(user);
        } else return Nullable.empty();
    }
}
