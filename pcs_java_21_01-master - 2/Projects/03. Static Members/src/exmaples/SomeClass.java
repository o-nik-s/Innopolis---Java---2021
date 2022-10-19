package exmaples;

import java.util.Random;

/**
 * 02.09.2021
 * 03. Static Members
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class SomeClass {
    int field;
    static int staticField;

    static {
        Random random = new Random();
        staticField = random.nextInt(100);
        staticMethod();
    }

    public void method() {
        System.out.println(field);
        System.out.println(staticField);
    }

    public static void staticMethod() {
//        System.out.println(field);
        System.out.println(staticField);
    }
}
