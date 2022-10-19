package state.impl.states;

import state.KeyValueStorage;

import java.util.StringJoiner;

/**
 * 29.09.2021
 * 22. Behavioral Patterns
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class KeyValueStorageImpl implements KeyValueStorage {

    KeyValueStorageState state;

    String fileName;

    public KeyValueStorageImpl(String fileName) {
        this.fileName = fileName;
        this.state = new MapState(this);
    }

    @Override
    public void put(String key, String value) {
        this.state.put(key, value);
    }

    @Override
    public String get(String key) {
        return state.get(key);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", KeyValueStorageImpl.class.getSimpleName() + "[", "]")
                .add("state=" + state)
                .toString();
    }
}
