package example1;

import java.util.Scanner;

/**
 * 08.11.2021
 * 15. Generics
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserService userService = new UserService();
        String email = scanner.nextLine();
        String password = scanner.nextLine();
        Nullable<User> userNullable = userService.signIn(email, password);

        if (userNullable.isEmpty()) {
            System.err.println("Пользователь не найден!");
        } else {
            User user = userNullable.get();
            System.out.println(user.getFirstName() + " " + user.getLastName());
        }
    }
}
