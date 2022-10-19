package example1;

/**
 * 03.11.2021
 * 12. Nested Classes
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
// внешний класс (outer)
public class Table {

    // вложенный класс (nested)
    private static class Entry {
        private String key;
        private int value;

        public Entry(String key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    // внутренний класс (inner)
    public class Operations {

        public String mergeKeys() {
            String result = "";
            for (int i = 0; i < count; i++) {
                result += entries[i].key + " ";
            }
            return result;
        }

        public double averageValues() {
            double sum = 0;
            for (int i = 0; i < count; i++) {
                sum += entries[i].value;
            }
            return sum / count;
        }
    }

    private static final int MAX_TABLE_SIZE = 5;

    private Entry entries[];

    private int count;

    public Table() {
        this.entries = new Entry[MAX_TABLE_SIZE];
        this.count = 0;
    }

    public void put(String key, int value) {
        // TODO: сделать проверку на переполнение
        // пробегаем все пары ключ-значение в таблице
        for (int i = 0; i < count; i++) {
            // если нашли пару, в которой уже есть этот ключ
            if (entries[i].key.equals(key)) {
                // заменяем значение
                entries[i].value = value;
                // останавливаем выполнение метода
                return;
            }
        }
        // положили новую пару ключ-значение в первую пустую ячейку таблицы
        this.entries[count] = new Entry(key, value);
        count++;
    }

    public int get(String key) {
        return -1;
    }

    public Entry[] getEntries() {
        return entries;
    }

    public int getCount() {
        return count;
    }
}
