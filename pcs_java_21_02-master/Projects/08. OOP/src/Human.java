/**
 * 27.10.2021
 * 08. OOP
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Human {

    // поля -> отвечают за состояние
    // fields

    private int age; // возраст

    private String name; // имя

    private int stepsCount = 0;

    // метод -> отвечают за поведение
    // methods
    public void go(int value) {
        if (value < 0) {
            value = 0;
        }
        this.stepsCount += value;
    }

    public void resetStepsCount() {
        this.stepsCount = 0;
    }

    // метод доступа, геттер - используется для получения значения закрытого поля
    public int getAge() {
        return this.age;
    }

    public int getStepsCount() {
        return this.stepsCount;
    }

    // метод доступа, сеттер - используется для задания корректного значения закрытого поля
    public void setAge(int age) {
        if (age < 0 || age > 120) {
            age = 0;
        }
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
