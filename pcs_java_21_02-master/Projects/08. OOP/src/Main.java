public class Main {

    public static void main(String[] args) {
        // создал объект
        // на объект указывает переменная marsel
        Human marsel = new Human();
//        marsel.age = 27;
        marsel.setAge(27);
//        marsel.name = "Марсель";
        marsel.setName("Марсель");
        // создал объект
        // на объект указывает переменная viktor
        Human viktor = new Human();
//        viktor.age = 22;
        viktor.setAge(22);
//        viktor.name = "Виктор";
        viktor.setName("Виктор");

        marsel.go(20);
        viktor.go(15);
        marsel.go(5);
        viktor.go(1);

        viktor.resetStepsCount();
//        marsel.stepsCount = -10;

        System.out.println(marsel.getName() + " " + marsel.getAge() + " " + marsel.getStepsCount());
        System.out.println(viktor.getName() + " " + viktor.getAge() + " " + viktor.getStepsCount());


    }
}
