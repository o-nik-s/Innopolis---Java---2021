package models;

/**
 * 31.08.2021
 * 02. OOP. Part 1
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Bus {
    private int number;
    private String model;

    private Passenger[] passengers;
    private int passengersCount;

    private Driver driver;

    private boolean inRoad;

    public Bus(int number, String model) {
        this.number = number;
        this.model = model;
        this.passengers = new Passenger[3];
        this.passengersCount = 0;
    }

    public int getNumber() {
        return number;
    }

    public String getModel() {
        return model;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public void go() {
        this.inRoad = true;
        System.out.println("Автобус <" + this.number + "> поехал под управлением - " + driver.getName());
        System.out.println("Наши пассажиры: ");
        for (int i = 0; i < passengersCount; i++) {
            System.out.println(passengers[i].getName());
        }
    }

    public void income(Passenger passenger) {

        String message = null;

        if (inRoad) {
            message = "Автобус не принимает пассажиров!";
        }

        if (this.passengersCount == passengers.length) {
            message = "Автобус переполнен!";
        }

        if (message != null) {
            System.err.println(message);
            return;
        }

        this.passengers[passengersCount] = passenger;
        this.passengersCount++;
    }
}
