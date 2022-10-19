package state.impl.states;

import java.util.ArrayList;
import java.util.List;

/**
 * 29.09.2021
 * 22. Behavioral Patterns
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class ListState implements KeyValueStorageState {

    static class KeyValue {
        String key;
        String value;

        public KeyValue(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    List<KeyValue> list = new ArrayList<>();

    private static final int MAX_SIZE = 5;

    private final KeyValueStorageImpl keyValueStorage;

    public ListState(KeyValueStorageImpl keyValueStorage) {
        this.keyValueStorage = keyValueStorage;
    }

    @Override
    public void put(String key, String value) {
        if (isOversize()) {
            nextState();
            copyData();
            keyValueStorage.put(key, value);
        } else {
            list.add(new KeyValue(key, value));
        }
    }

    private void copyData() {
        for (KeyValue keyValue : list) {
            keyValueStorage.put(keyValue.key, keyValue.value);
        }
    }

    private void nextState() {
        keyValueStorage.state = new FileState(keyValueStorage);
    }

    private boolean isOversize() {
        return list.size() > MAX_SIZE;
    }

    @Override
    public String get(String key) {
        for (KeyValue keyValue : list) {
            if (keyValue.key.equals(key)) {
                return keyValue.value;
            }
        }
        return null;
    }
}
