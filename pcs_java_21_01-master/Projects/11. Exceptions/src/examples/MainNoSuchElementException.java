package examples;

import java.util.ArrayList;
import java.util.List;

/**
 * 08.09.2021
 * 11. Exceptions
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class MainNoSuchElementException {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.iterator().next();
    }
}
