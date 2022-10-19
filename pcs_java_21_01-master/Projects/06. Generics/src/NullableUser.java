/**
 * 03.09.2021
 * 06. Generics
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class NullableUser {
    private User value;

    private NullableUser(User value) {
        this.value = value;
    }

    public static NullableUser of(User value) {
        return new NullableUser(value);
    }

    public static NullableUser empty() {
        return new NullableUser(null);
    }

    public boolean isPresent() {
        return value != null;
    }

    public User get() {
        return value;
    }

}
