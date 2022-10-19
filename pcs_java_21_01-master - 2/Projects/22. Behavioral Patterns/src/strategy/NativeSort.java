package strategy;

import java.util.Arrays;

/**
 * 29.09.2021
 * 22. Behavioral Patterns
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class NativeSort implements Sort {
    @Override
    public void sort(int[] array) {
        Arrays.sort(array);
    }
}
