package object;

/**
 * 07.09.2021
 * 09. Object, String, Wrappers
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class User {
    private int age;
    private double height;

    public User(int age, double height) {
        this.age = age;
        this.height = height;
    }

    public int getAge() {
        return age;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return "User(age = " + age + ", height = " + height + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof User)) {
            return false;
        }

        User that = (User)obj;

        return this.age == that.age && this.height == that.height;

    }
}
