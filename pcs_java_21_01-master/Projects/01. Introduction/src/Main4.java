import java.util.Arrays;

/**
 * 30.08.2021
 * 01. Introduction
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Main4 {

    public static void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int x = 5;
        int y = 10;
        swap(x, y);
        System.out.println("x = " + x + ", y = " + y);

        int[] a = {1, 2, 3, 4, 5};
        swap(a, 2, 3);
        System.out.println(Arrays.toString(a));

    }
}
