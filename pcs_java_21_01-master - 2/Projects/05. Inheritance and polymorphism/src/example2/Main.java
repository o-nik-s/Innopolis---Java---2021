package example2;

/**
 * 02.09.2021
 * 05. Inheritance and polymorphism
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Main {
    public static void main(String[] args) {
        A a = new A();
        B b = new B();

        a.method();
        b.method();
        // восходящее преобразование
        b = a;

        b.method();
    }
}
