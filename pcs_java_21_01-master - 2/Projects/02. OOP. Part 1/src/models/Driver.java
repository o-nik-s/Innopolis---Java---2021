package models;

/**
 * 31.08.2021
 * 02. OOP. Part 1
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Driver {
    private String name;
    private int experience;

    private Bus bus;

    public Driver(String name, int experience) {
        this.name = name;
        if (experience < 0) {
            this.experience = 0;
        } else {
            this.experience = experience;
        }
    }

    public String getName() {
        return name;
    }

    public int getExperience() {
        return experience;
    }

    public void go(Bus bus) {
        this.bus = bus;
        this.bus.setDriver(this);
    }

    public void drive() {
        this.bus.go();
    }
}
