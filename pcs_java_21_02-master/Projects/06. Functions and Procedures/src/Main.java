public class Main {

    /**
     * Возвращает количество цифр определенного числа
     * @param number число, для которого нужно получить количество цифр
     * @return количество цифр входного числа
     */
    public static int getDigitsCount(int number) {
        // тело функции
        int count = 0;

        while (number != 0) {
            number /= 10;
            count++;
        }
        // return - оператор возврата значения из функции
        // результат будет возвращен туда, где был вызов функции
        return count;
    }

    public static double getAverage(int[] array) {
        double sum = 0;

        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }

        return sum / array.length;
    }

    public static double getAverage(int from, int to) {
        double sum = 0;

        for (int i = from; i <= to; i++) {
            sum += i;
        }

        return sum / ((to - from) + 1) ;
    }

    public static void print(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void print(int from, int to) {
        if (to < from) {
            return;
        }

        for (int i = from; i <= to; i++) {
            System.out.print(i + " ");
        }
    }



    public static void main(String[] args) {
        int[] a = {3, 10, -5, 15, 23, 48, -30};
	    int result = getDigitsCount(5679);
	    int result1 = getDigitsCount(1090901);
        double result3 = getAverage(a);
        double result4 = getAverage(10, 15);
        System.out.println(result + " " + result1 + " " + result3 + " " + result4);
        print(a);
        print(10, 15);
        print(15, 10);
    }
}
