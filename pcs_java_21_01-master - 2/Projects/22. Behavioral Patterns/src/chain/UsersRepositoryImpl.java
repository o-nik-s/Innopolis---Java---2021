package chain;

/**
 * 29.09.2021
 * 22. Behavioral Patterns
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class UsersRepositoryImpl implements UsersRepository {
    @Override
    public User findByEmail(String email) {
        if (email.equals("sidikov.m@mxm.email")) {
            return new User(email, "qwerty007");
        }
        return null;
    }
}
