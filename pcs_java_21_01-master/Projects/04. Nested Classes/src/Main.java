public class Main {

    public static void main(String[] args) {
	    Table table = new Table();
	    table.put("Марсель", 27);
	    table.put("Алия", 21);
	    table.put("Айрат", 22);

	    Table anotherTable = new Table();
	    anotherTable.put("Пользователь 1", 33);
		anotherTable.put("Пользователь 2", 44);
		anotherTable.put("Пользователь 3", 77);

//		Table.TableEntry entry = new Table.TableEntry("Виктор", 24);

		Table.TableIterator iterator1 = table.new TableIterator();
		iterator1.next();
		System.out.println(iterator1.key() + " " + iterator1.value());
		iterator1.next();
		System.out.println(iterator1.key() + " " + iterator1.value());
		iterator1.next();
		System.out.println(iterator1.key() + " " + iterator1.value());

		Table.TableIterator iterator2 = table.new TableIterator();
		iterator2.next();
		System.out.println(iterator2.key() + " " + iterator2.value());
		iterator2.next();
		System.out.println(iterator2.key() + " " + iterator2.value());
		iterator2.next();
		System.out.println(iterator2.key() + " " + iterator2.value());

		Table.TableIterator iterator3 = anotherTable.new TableIterator();
		iterator3.next();
		System.out.println(iterator3.key() + " " + iterator3.value());
		iterator3.next();
		System.out.println(iterator3.key() + " " + iterator3.value());
		iterator3.next();
		System.out.println(iterator3.key() + " " + iterator3.value());

    }
}
