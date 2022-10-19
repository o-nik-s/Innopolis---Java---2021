package object;

import java.util.Objects;
import java.util.StringJoiner;

/**
 * 07.11.2021
 * 14. Object and String
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class User {
    private String firstName;
    private String lastName;
    private int age;
    private boolean isWorker;

    public User(String firstName, String lastName, int age, boolean isWorker) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.isWorker = isWorker;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", User.class.getSimpleName() + "[", "]")
                .add("firstName='" + firstName + "'")
                .add("lastName='" + lastName + "'")
                .add("age=" + age)
                .add("isWorker=" + isWorker)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age && isWorker == user.isWorker && Objects.equals(firstName, user.firstName) && Objects.equals(lastName, user.lastName);
    }
}
