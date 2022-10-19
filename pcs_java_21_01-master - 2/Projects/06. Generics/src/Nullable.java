/**
 * 03.09.2021
 * 06. Generics
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Nullable<T> {
    private T value;

    private Nullable(T value) {
        this.value = value;
    }

    // статический обобщенный метод
    // буква E подставляется исходя из параметра value
    // какого типа будет value, такого же типа будет и Nullable
    public static <E> Nullable<E> of(E value) {
        return new Nullable<>(value);
    }

    public static <T> Nullable<T> empty() {
        return new Nullable<>(null);
    }

    public boolean isPresent() {
        return value != null;
    }

    public T get() {
        return value;
    }
}
