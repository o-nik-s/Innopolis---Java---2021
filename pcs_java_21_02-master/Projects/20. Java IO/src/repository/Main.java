package repository;

import java.util.List;

/**
 * 15.11.2021
 * 20. Java IO
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Main {
    public static void main(String[] args) {
        UsersRepository usersRepository = new UsersRepositoryFileImpl("users.txt");
        List<User> users = usersRepository.findAll();

        for (User user : users) {
            System.out.println(user.getAge() + " " + user.getName() + " " + user.isWorker());
        }

        User user = new User("Игорь", 33, true);
        usersRepository.save(user);
    }
}
