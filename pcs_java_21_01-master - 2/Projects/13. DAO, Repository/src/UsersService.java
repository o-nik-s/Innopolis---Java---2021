/**
 * 12.09.2021
 * 13. DAO, Repository
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class UsersService {

    private final UsersRepository usersRepository;

    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public void signUp(String email, String password) {
        if (!usersRepository.existsByEmail(email)) {
            User user = new User(email, password);
            usersRepository.save(user);
        } else throw new IllegalArgumentException("Email already exists");
    }
}
