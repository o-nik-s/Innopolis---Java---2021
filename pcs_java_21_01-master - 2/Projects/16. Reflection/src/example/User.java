package example;

/**
 * 22.09.2021
 * 16. Reflection
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class User {
    private String name;
    private int stepsCount;

    public User() {
    }

    public User(String name) {
        this.name = name;
        this.stepsCount = 0;
    }

    public void say() {
        System.out.println(name);
    }

    public int go(int steps) {
        this.stepsCount += steps;
        return this.stepsCount;
    }

    public String getName() {
        return name;
    }

}
