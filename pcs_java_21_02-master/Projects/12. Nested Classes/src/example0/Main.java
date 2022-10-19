package example0;

public class Main {

    public static void main(String[] args) {
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

        TableOperations operations = new TableOperations(table);
        System.out.println(operations.mergeKeys());
        System.out.println(operations.averageValues());

        TableOperations operations1 = new TableOperations(table1);
        System.out.println(operations1.mergeKeys());
        System.out.println(operations1.averageValues());
        int i = 0;
    }
}
