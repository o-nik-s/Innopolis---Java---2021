package example4;

/**
 * 29.10.2021
 * 09. Inheritance
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Main {
    public static void main(String[] args) {
        Car car = new Car(10);
        SportCar sportCar = new SportCar(90, 30);
        car.go();
        sportCar.go();
    }
}
