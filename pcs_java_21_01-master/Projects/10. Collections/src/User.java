import java.util.Objects;

/**
 * 07.09.2021
 * 10. Collections
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class User {
    private int age;
    private double height;
    private String name;
    private boolean isWorker;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age &&
                Double.compare(user.height, height) == 0 &&
                isWorker == user.isWorker &&
                Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, height, name, isWorker);
    }
}
