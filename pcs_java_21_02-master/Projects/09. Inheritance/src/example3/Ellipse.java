package example3;

/**
 * 29.10.2021
 * 09. Inheritance
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Ellipse {
    protected double radius1;
    private double radius2;

    public Ellipse(double radius1, double radius2) {
        this.radius1 = radius1;
        this.radius2 = radius2;
    }

    public void paint() {
        System.out.println("Овал - " + radius1 + " " + radius2);
    }
}
