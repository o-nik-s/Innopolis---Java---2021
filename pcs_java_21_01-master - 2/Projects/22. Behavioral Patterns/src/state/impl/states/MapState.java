package state.impl.states;

import java.util.HashMap;
import java.util.Map;

/**
 * 29.09.2021
 * 22. Behavioral Patterns
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class MapState implements KeyValueStorageState {

    HashMap<String, String> map = new HashMap<>();

    private static final int MAX_SIZE = 3;

    private final KeyValueStorageImpl keyValueStorage;

    public MapState(KeyValueStorageImpl keyValueStorage) {
        this.keyValueStorage = keyValueStorage;
    }

    @Override
    public void put(String key, String value) {
        if (isOversize()) {
            nextState();
            copyData();
            keyValueStorage.put(key, value);
        } else {
            map.put(key, value);
        }
    }

    private boolean isOversize() {
        return map.size() > MAX_SIZE;
    }

    private void nextState() {
        keyValueStorage.state = new ListState(keyValueStorage);
    }

    private void copyData() {
        for (Map.Entry<String, String> keyValue : map.entrySet()) {
            keyValueStorage.put(keyValue.getKey(), keyValue.getValue());
        }
    }

    @Override
    public String get(String key) {
        return map.get(key);
    }
}
