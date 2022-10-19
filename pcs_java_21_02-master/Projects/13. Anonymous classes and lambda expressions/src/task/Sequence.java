package task;

/**
 * 05.11.2021
 * 13. Anonymous classes and lambda expressions
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Sequence {
    public static int[] map(int[] array, Mapper mapper) {
        int[] result = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = mapper.map(array[i]);
        }
        return result;
    }

    public static int[] process(int[] array, TwoNumbersMapper mapper) {
        int[] result = new int[array.length / 2];
        int current = 0;
        for (int i = 0; i < array.length - 1; i++) {
            result[current] = mapper.map(array[i], array[i+1]);
            current ++;
            i += 1;
        }
        return result;
    }
}
