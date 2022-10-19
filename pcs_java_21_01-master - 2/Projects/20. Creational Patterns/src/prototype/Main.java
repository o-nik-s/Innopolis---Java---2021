package prototype;

/**
 * 27.09.2021
 * 20. Creational Patterns
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Main {
    public static void main(String[] args) {
        User user = new User("sidikov.marsel@gmail.com");
        user.authorize();

        System.out.println(user.isAuthorized());

//        User user1 = new User(user.getEmail());
        User user1 = user.clone();
        System.out.println(user1.isAuthorized());


    }
}
