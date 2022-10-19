package state;

import state.impl.states.KeyValueStorageImpl;

/**
 * 29.09.2021
 * 22. Behavioral Patterns
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Main {
    public static void main(String[] args) {
        KeyValueStorage storage = new KeyValueStorageImpl("data.txt");
        storage.put("User1", "Pass1");
        storage.put("User2", "Pass2");
        storage.put("User3", "Pass3");
        storage.put("User4", "Pass4");
        System.out.println(storage.get("User4"));
        storage.put("User5", "Pass5");
        storage.put("User6", "Pass6");
        System.out.println(storage.get("User6"));
        storage.put("User7", "Pass7");
        storage.put("User8", "Pass8");
        storage.put("User9", "Pass9");
        System.out.println(storage.get("User8"));
    }
}
