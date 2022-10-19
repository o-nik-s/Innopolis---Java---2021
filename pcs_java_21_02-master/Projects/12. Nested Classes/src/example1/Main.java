package example1;

/**
 * 03.11.2021
 * 12. Nested Classes
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Main {
    public static void main(String[] args) {
//        Table.TableEntry entry = new Table.TableEntry("Привет", 30);

        Table table = new Table();
        table.put("Марсель", 27);
        table.put("Виктор", 24);
        table.put("Максим", 22);
        table.put("Марсель", 28);

        Table table1 = new Table();
        table1.put("Игорь", 35);
        table1.put("Валерий", 29);
        table1.put("Александр", 49);
        table1.put("Марк", 30);
        table1.put("Марат", 50);
        // созданный operations ассоциируется с внешним объектом table
        Table.Operations operations = table.new Operations();
        System.out.println(operations.averageValues());
        System.out.println(operations.mergeKeys());
        // созданный operations1 ассоциируется с внешним объектом table1
        Table.Operations operations1 = table1.new Operations();
        System.out.println(operations1.averageValues());
        System.out.println(operations1.mergeKeys());
        Table.Operations operations2 = table1.new Operations();

        int i = 0;
    }
}
