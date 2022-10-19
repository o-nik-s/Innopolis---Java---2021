package factroy_method;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * 27.09.2021
 * 20. Creational Patterns
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Main2 {

    public static void printAll(List<?> elements) {
        Iterator<?> iterator = elements.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>();
        List<String> strings = new LinkedList<>();

        integers.add(10);
        integers.add(20);
        integers.add(30);

        strings.add("Hello");
        strings.add("Marsel");
        strings.add("Bye");

        printAll(integers);
        printAll(strings);
    }
}
