package example4;

/**
 * 29.10.2021
 * 09. Inheritance
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Car {
    protected int km;

    public Car(int km) {
        this.km = km;
    }

    public void go() {
        km += 1;
        System.out.println("Машина поехала на 1 км!");
    }
}
