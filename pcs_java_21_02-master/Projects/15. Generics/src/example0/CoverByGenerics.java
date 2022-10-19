package example0;

/**
 * 08.11.2021
 * 15. Generics
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class CoverByGenerics<T> {
    private T phone;

    public T getPhone() {
        return phone;
    }

    public void setPhone(T phone) {
        this.phone = phone;
    }
}
