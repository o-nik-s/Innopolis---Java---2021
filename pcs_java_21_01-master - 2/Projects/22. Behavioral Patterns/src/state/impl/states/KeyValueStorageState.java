package state.impl.states;

/**
 * 29.09.2021
 * 22. Behavioral Patterns
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public interface KeyValueStorageState {
    void put(String key, String value);

    String get(String key);
}
