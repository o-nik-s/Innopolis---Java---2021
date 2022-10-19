package exmaples;

public class Main {

    public static void main(String[] args) {
        System.out.println(SomeClass.staticField);
        SomeClass a = new SomeClass();
        a.field = 10;
        a.staticField = 30;
        SomeClass b = new SomeClass();
        b.field = 20;
        b.staticField = 40;

        System.out.println(a.field);
        System.out.println(b.field);

        SomeClass.staticField = 50;

        System.out.println(a.staticField);
        System.out.println(b.staticField);
        System.out.println(SomeClass.staticField);
        System.out.println("----");
        a.method();
    }
}
