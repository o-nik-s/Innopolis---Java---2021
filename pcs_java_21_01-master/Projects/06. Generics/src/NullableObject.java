/**
 * 03.09.2021
 * 06. Generics
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class NullableObject {
    private Object value;

    private NullableObject(Object value) {
        this.value = value;
    }

    public static NullableObject of(Object value) {
        return new NullableObject(value);
    }

    public static NullableObject empty() {
        return new NullableObject(null);
    }

    public boolean isPresent() {
        return value != null;
    }

    public Object get() {
        return value;
    }
}
