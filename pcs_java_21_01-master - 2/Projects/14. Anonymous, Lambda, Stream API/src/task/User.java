package task;

import java.util.StringJoiner;

/**
 * 14.09.2021
 * 14. Anonymous, Lambda, Stream API
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class User {
    private long id;
    private String name;
    private int age;
    private double height;

    public User(long id, String name, int age, double height) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.height = height;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", User.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("firstName='" + name + "'")
                .add("age=" + age)
                .add("height=" + height)
                .toString();
    }
}
