package example1;

/**
 * 08.11.2021
 * 15. Generics
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
// Optional
public class Nullable<T> {
    private T value;

    private Nullable(T value) {
        this.value = value;
    }

    public static <T> Nullable<T> of(T value) {
        return new Nullable<>(value);
    }

    public static <T> Nullable<T> empty() {
        return new Nullable<>(null);
    }

    public boolean isEmpty() {
        return value == null;
    }

    public T get() {
        return value;
    }
}
