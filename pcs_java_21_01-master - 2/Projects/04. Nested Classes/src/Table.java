/**
 * 02.09.2021
 * 04. Nested Classes
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Table {
    private static final int MAX_SIZE = 5;

    // статический вложенный класс - вложенный
    private static class TableEntry {
        private String key;
        private int value;

        public TableEntry(String key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    // внутренний класс
    public class TableIterator {
        private int current = -1;

        public void next() {
            if (current < count) {
                current++;
            } else System.err.println("Дальше элемент нет");
        }

        public String key() {
            return entries[current].key;
        }

        public int value() {
            return entries[current].value;
        }
    }

    private TableEntry[] entries;
    private int count;

    public Table() {
        this.entries = new TableEntry[MAX_SIZE];
        this.count = 0;
    }

    public void put(String key, int value) {
        // TODO: замена значения, т.е. put("Марсель", 27), put("Марсель", 28)
        // TODO: переполнение массива
        TableEntry entry = new TableEntry(key, value);
        entries[count] = entry;
        count++;
    }

    // get("Марсель") -> 27
    public int get(String key) {
        for (int i = 0; i < count; i++) {
            if (entries[i].key.equals(key)) {
                return entries[i].value;
            }
        }
        return 0;
    }

    public int getCount() {
        return count;
    }
}
