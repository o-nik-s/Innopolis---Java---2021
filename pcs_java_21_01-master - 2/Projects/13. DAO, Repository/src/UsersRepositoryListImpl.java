import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * 12.09.2021
 * 13. DAO, Repository
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class UsersRepositoryListImpl implements UsersRepository {

    private List<User> users;

    public UsersRepositoryListImpl() {
        this.users = new ArrayList<>();
    }

    @Override
    public void update(User user) {

    }

    @Override
    public Optional<User> findByEmail(String email) {
        return Optional.empty();
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public void delete(User user) {

    }

    @Override
    public void save(User user) {
        users.add(user);
    }

    @Override
    public int count() {
        return users.size();
    }

    @Override
    public boolean existsByEmail(String email) {
        return false;
    }
}
