package example;

public class Main {

    public static void main(String[] args) {
        Util x = new Util();
        x.a = 10;
//        x.b = 100;
        Util y = new Util();
        y.a = 15;
//        y.b = 200;

        System.out.println(x.b);
        System.out.println(y.b);
        System.out.println(Util.b);
        System.out.println(Math.abs(-10));
        System.out.println(Math.sqrt(100));
        System.out.println(Math.PI);
    }
}
