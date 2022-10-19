public class Main {

    public static void main(String[] args) {
        int i = 775; // 4 байта -> 8 бит * 4 = 32 бита
        int[] a = new int[3]; // а - хранит адрес массива из трех элементов, пусть в a -> 0x78787
        a[0] = 7;
        a[1] = 8;
        a[2] = 9;

        int[] b = a; // b -> 0x78787
        b[1] = 999;

        System.out.println(a[1]);
        // int -> double
        double x = 7 / 2;
        System.out.println(x);
        int t = 3;
        // неявное преобразование, int -> double
        double y = t;
        double z = 7.5;
        int r = (int)z;
    }
}
