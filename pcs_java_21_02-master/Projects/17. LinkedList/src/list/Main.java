package list;

/**
 * 11.11.2021
 * 17. LinkedList
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(34);
        list.add(120);
        list.add(-10);
        list.add(11);
        list.add(50);
        list.add(100);
        list.add(99);

        list.addToBegin(77);
        list.addToBegin(88);
        list.addToBegin(99);

    }
}
