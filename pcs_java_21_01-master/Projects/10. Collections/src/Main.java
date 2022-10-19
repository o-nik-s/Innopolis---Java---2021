import java.util.*;

public class Main {

    public static void main(String[] args) {
        System.out.println(15 & "abc".hashCode());
        ArrayList<String> list = new ArrayList<>();
        list.add("Привет");
        list.add("Марсель");
        list.add("Как дела");
        list.add("Что нового");
        list.add("Пока");

        Iterator<String> stringIterator = list.iterator();

        while (stringIterator.hasNext()) {
            System.out.println(stringIterator.next());
        }
//
        Map<String, Integer> map = new HashMap<>();

        map.put("Марсель", 27);
        map.put("Марсель", 28);
        int i = map.get("Марсель");

        Set<String> names = new HashSet<>();
        names.add("Марсель");
        names.add("Марсель");
        names.add("Сидиков");

        for (String name :
                names) {
            System.out.println(name);
        }
//	    for (String text : list) {
//            System.out.println(text);
//        }
    }
}
