package state.impl.states;

import java.io.*;

/**
 * 29.09.2021
 * 22. Behavioral Patterns
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class FileState implements KeyValueStorageState {
    private final KeyValueStorageImpl keyValueStorage;

    public FileState(KeyValueStorageImpl keyValueStorage) {
        this.keyValueStorage = keyValueStorage;
    }


    @Override
    public void put(String key, String value) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(keyValueStorage.fileName, true))) {
            writer.write(key + "|" + value);
            writer.newLine();
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public String get(String key) {
        try (BufferedReader reader = new BufferedReader(new FileReader(keyValueStorage.fileName))) {
            String line = reader.readLine();

            while (line != null) {
                String[] keyValue = line.split("\\|");

                if (keyValue[0].equals(key)) {
                    return keyValue[1];
                }

                line = reader.readLine();
            }

            return null;
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }
}
