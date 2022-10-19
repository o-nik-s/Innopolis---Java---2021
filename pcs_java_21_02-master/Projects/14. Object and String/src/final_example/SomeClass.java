package final_example;

import object.Human;

import java.util.Scanner;

/**
 * 07.11.2021
 * 14. Object and String
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public final class SomeClass {
    public final int value;

    public final Human human = new Human(27, true);

//    public final int array[];

    public SomeClass() {
        this.value = 10;
    }

    public SomeClass(int value) {
        this.value = value;
    }

    public SomeClass(String value) {
        this.value = 15;
        System.out.println(value);
    }

    public final void changeAge(int age) {
        this.human.setAge(28);
//        this.human = new Human(25, true);
    }
}
