package intro;

/**
 * 31.08.2021
 * 02. OOP. Part 1
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class User {
    // fields (поля) - определяют состояние объекта
    private int age;
    double height;
    public String name;
    int stepsCount;

    public User() {
    }

    public User(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public User(User orig) {
        age = orig.age;
        height = orig.height;
        name = orig.name;
        stepsCount = orig.stepsCount;
    }

    public User(int age, double height, String name) {
        this.age = age;
        this.height = height;
        this.name = name;
        this.stepsCount = 0;
    }

    // метод, определяет поведение объекта
    void go(int steps) {
        stepsCount += steps;
    }

    // метод доступа - сеттер
    public void setAge(int age) {
        if (age < 0) {
            this.age = 0;
        } else {
            this.age = age;
        }
    }

    // метод доступа - геттер
    public int getAge() {
        return this.age;
    }


}
