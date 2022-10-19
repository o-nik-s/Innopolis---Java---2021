package strategy;

import java.util.Arrays;

/**
 * 29.09.2021
 * 22. Behavioral Patterns
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Sequence {
    private int[] array;

    private Sort sort;

    public Sequence(int[] array) {
        this.array = new int[array.length];
        System.arraycopy(array, 0, this.array, 0, array.length);
    }

    public void sort() {
        sort.sort(this.array);
    }

    public void setSort(Sort sort) {
        this.sort = sort;
    }

    public void printSequence() {
        System.out.println(Arrays.toString(array));
    }
}
