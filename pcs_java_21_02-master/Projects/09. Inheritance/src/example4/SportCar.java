package example4;

/**
 * 29.10.2021
 * 09. Inheritance
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class SportCar extends Car {
    private int speed;

    public SportCar(int speed, int km) {
        super(km);
        this.speed = speed;
    }

    public void go() {
        km += speed;
        System.out.println("Гоночная машина проехала " + speed);
        System.out.println("Гоночная машина проехала всего " + km);
    }
}
