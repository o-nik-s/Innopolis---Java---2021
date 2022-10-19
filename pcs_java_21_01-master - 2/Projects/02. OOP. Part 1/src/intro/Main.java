package intro;

public class Main {

//    public static void go(User user, int steps) {
//        user.stepsCount += steps;
//    }

    public static void main(String[] args) {
        User marsel = new User(27, 1.85, "Марсель Сидиков");

        User maxim = new User(22, 1.79, "Максим Поздеев");

        User notMaxim = new User(maxim);

//        go(marsel, 10);
//        go(maxim, 15);

        marsel.go(10);
        maxim.go(15);

        System.out.println(marsel.stepsCount);
        System.out.println(maxim.stepsCount);

        marsel = maxim;
        marsel.name = "Привет!";
        System.out.println(maxim.name);

        User igor = null;
        igor.name = "Игорь";
    }
}
