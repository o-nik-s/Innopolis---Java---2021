package object;

public class Main {

    public static void main(String[] args) {
        User user = new User(27, 1.85);
        User user1 = new User(27, 1.85);
        User user2 = new User(27, 1.85);
        User user3 = new User(27, 1.85);

        System.out.println(user.equals(user1));
        System.out.println(ObjectsUtils.isEqual(user, user1, user2, user3));
    }
}
