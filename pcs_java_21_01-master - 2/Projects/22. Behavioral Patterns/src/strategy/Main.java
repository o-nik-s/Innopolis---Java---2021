package strategy;

/**
 * 29.09.2021
 * 22. Behavioral Patterns
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Main {
    public static void main(String[] args) {
        Sequence sequence = new Sequence(new int[]{9, 10, -5, 2, 4, 1, 10, -100});
        sequence.setSort(new NativeSort());
        sequence.sort();
        sequence.printSequence();
    }
}
