import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
//        UsersRepository usersRepository = new UsersRepositoryListImpl();
        IdGenerator idGenerator = new IdGeneratorFileImpl("users_id.txt");
        UsersRepository usersRepository = new UsersRepositoryFileImpl("users.txt", idGenerator);
        UsersService usersService = new UsersService(usersRepository);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            String email = scanner.nextLine();
            String password = scanner.nextLine();

            usersService.signUp(email, password);
        }
    }
}
