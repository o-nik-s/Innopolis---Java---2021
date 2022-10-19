/**
 * 03.09.2021
 * 06. Generics
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class NullableString {
    private String value;

    private NullableString(String value) {
        this.value = value;
    }

    public static NullableString of(String value) {
        return new NullableString(value);
    }

    public static NullableString empty() {
        return new NullableString(null);
    }

    public boolean isPresent() {
        return value != null;
    }

    public String get() {
        return value;
    }

}
