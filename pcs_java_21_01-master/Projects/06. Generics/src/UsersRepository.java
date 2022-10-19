/**
 * 03.09.2021
 * 06. Generics
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class UsersRepository {

    private User[] users = new User[]{new User("Марсель", 27),
            new User("Максим", 22),
            new User("Айрат", 23)};

    public Nullable<User> findUserByName(String name) {
        for (int i = 0; i < users.length; i++) {
            if (users[i].getName().equals(name)) {
                return Nullable.of(users[i]);
            }
        }

        return Nullable.empty();
    }
}
