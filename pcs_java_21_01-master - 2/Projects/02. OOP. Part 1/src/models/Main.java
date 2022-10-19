package models;

/**
 * 31.08.2021
 * 02. OOP. Part 1
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Main {
    public static void main(String[] args) {
        Bus bus = new Bus(22, "НЕФАЗ");
        Driver driver = new Driver("Сергей", 20);

        driver.go(bus);

        Passenger passenger1 = new Passenger("Пассажир 1");
        Passenger passenger2 = new Passenger("Пассажир 2");
        Passenger passenger3 = new Passenger("Пассажир 3");
        Passenger passenger4 = new Passenger("Пассажир 4");

        passenger1.go(bus);
        passenger2.go(bus);
        passenger3.go(bus);
        passenger4.go(bus);

        driver.drive();
    }
}
