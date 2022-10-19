package task;

/**
 * 14.09.2021
 * 14. Anonymous, Lambda, Stream API
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Main {
    public static void main(String[] args) {
        UsersRepository usersRepository = new UsersRepository("input.txt");

        System.out.println(usersRepository.findAll().stream()
                .mapToDouble(User::getHeight)
                .filter(height -> height < 1.50)
                .distinct()
                .max()
                .orElse(0.0));


    }
}
