package example0;

/**
 * 03.11.2021
 * 12. Nested Classes
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Table {

    private static final int MAX_TABLE_SIZE = 5;

    private TableEntry entries[];

    private int count;

    public Table() {
        this.entries = new TableEntry[MAX_TABLE_SIZE];
        this.count = 0;
    }

    public void put(String key, int value) {
        // TODO: сделать проверку на переполнение
        // пробегаем все пары ключ-значение в таблице
        for (int i = 0; i < count; i++) {
            // если нашли пару, в которой уже есть этот ключ
            if (entries[i].getKey().equals(key)) {
                // заменяем значение
                entries[i].setValue(value);
                // останавливаем выполнение метода
                return;
            }
        }
        // положили новую пару ключ-значение в первую пустую ячейку таблицы
        this.entries[count] = new TableEntry(key, value);
        count++;
    }

    public int get(String key) {
        return -1;
    }

    public TableEntry[] getEntries() {
        return entries;
    }

    public int getCount() {
        return count;
    }
}
