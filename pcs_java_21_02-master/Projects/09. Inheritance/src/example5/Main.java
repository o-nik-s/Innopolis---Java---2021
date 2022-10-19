package example5;

/**
 * 29.10.2021
 * 09. Inheritance
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Main {
    public static void main(String[] args) {
        Human human = new Human();
        Programmer programmer = new Programmer();
        Sportsman sportsman = new Sportsman();
        Student student = new Student();

        human.work();
        programmer.work();
        sportsman.work();
        student.work();
    }
}
