import java.util.List;
import java.util.Optional;

/**
 * 12.09.2021
 * 13. DAO, Repository
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public interface UsersRepository {
    void update(User user);
    Optional<User> findByEmail(String email);
    List<User> findAll();
    void delete(User user);
    void save(User user);
    int count();

    boolean existsByEmail(String email);


}
