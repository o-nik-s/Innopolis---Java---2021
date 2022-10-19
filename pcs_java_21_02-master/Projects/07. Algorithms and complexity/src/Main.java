import java.util.Arrays;

public class Main {

    public static void selectionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int min = array[i];
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                System.out.println("Hello");
                if (array[j] < min) {
                    min = array[j];
                    minIndex = j;
                }
            }
            // когда вышли из этого цикла, то мы знаем, что в min - лежит минимальный элемент
            // из диапазона [i..array.length-1]
            // ставим его в начало
            int temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;

//            System.out.println(Arrays.toString(array));
        }
    }

    public static boolean search(int[] array, int element) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == element) {
                return true;
            }
        }
        return false;
    }

    public static boolean binarySearch(int[] array, int element) {
        int left = 0;
        int right = array.length - 1;
        int middle = left + (right - left) / 2;

        while (left <= right) {
            if (element < array[middle]) {
                // идем влево
                right = middle - 1;
            } else if (element > array[middle]) {
                // идем вправо
                left = middle + 1;
            } else {
                // нашли число
                return true;
            }
            middle = left + (right - left) / 2;
        }
        // если до этого не был вызван return
        return false;
    }

    public static void main(String[] args) {
        // 8 -> (8^2 - 8) / 2 = 28
        int[] a = {45, 10, -1, 40, 25, 30, -5, 8};
        System.out.println(search(a, 30));
        System.out.println(search(a, 100));
        selectionSort(a);
        System.out.println(binarySearch(a, 30));
        System.out.println(binarySearch(a, 100));
        System.out.println((8 * 8 - 8)/2);
    }
}
