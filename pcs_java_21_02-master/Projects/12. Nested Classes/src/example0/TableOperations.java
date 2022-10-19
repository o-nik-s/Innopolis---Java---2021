package example0;

/**
 * 03.11.2021
 * 12. Nested Classes
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class TableOperations {
    // ссылка на таблицу, с которой я работаю
    private Table table;

    public TableOperations(Table table) {
        this.table = table;
    }

    public String mergeKeys() {
        TableEntry[] entries = table.getEntries();
        String result = "";
        for (int i = 0; i < table.getCount(); i++) {
            result += entries[i].getKey() + " ";
        }
        return result;
    }

    public double averageValues() {
        TableEntry[] entries = table.getEntries();
        double sum = 0;
        for (int i = 0; i < table.getCount(); i++) {
            sum += entries[i].getValue();
        }
        return sum / table.getCount();
    }
}
