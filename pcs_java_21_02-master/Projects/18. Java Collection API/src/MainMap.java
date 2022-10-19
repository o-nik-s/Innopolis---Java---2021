import java.util.*;

public class MainMap {

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();

        map.put("Марсель", 27);
        map.put("Виктор", 24);
        map.put("Максим", 22);
        map.put("Марсель", 28);

        Set<String> keys = map.keySet();

        for (String key : keys) {
            System.out.println(key);
        }

        Collection<Integer> values = map.values();

        for (int value : values) {
            System.out.println(value);
        }

        Set<Map.Entry<String, Integer>> entries = map.entrySet();

        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println("Имя - " + entry.getKey() + ", возраст - " + entry.getValue());
        }
//
//        System.out.println(map.get("Марсель"));
//        System.out.println(map.get("Виктор"));
//        System.out.println(map.get("Максим"));



    }
}
