package compare;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 07.09.2021
 * 09. Object, String, Wrappers
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Main {

    public static void sort(int array[]) {
        for (int i = array.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public static <T extends Comparable<T>> void sort(T[] array) {
        for (int i = array.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j].compareTo(array[j + 1]) > 0) {
                    T temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public static <T> void sort(T[] array, Comparator<T> comparator) {
        for (int i = array.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (comparator.compare(array[j], array[j + 1]) > 0) {
                    T temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int array[] = {32, 10, 56, 90, 11, 14};

        Point[] points = {
                new Point(10, 15),
                new Point(11, 8),
                new Point(56, 11),
                new Point(14, 5),
                new Point(8, 90),
                new Point(100, -3)};


        Comparator<Point> pointComparator = new PointByYComparator();
        sort(points, pointComparator);

        System.out.println(Arrays.toString(points));
    }
}
