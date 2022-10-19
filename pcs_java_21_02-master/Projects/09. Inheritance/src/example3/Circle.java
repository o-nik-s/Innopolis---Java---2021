package example3;

/**
 * 29.10.2021
 * 09. Inheritance
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Circle extends Ellipse {
    public Circle(double radius) {
        super(radius, radius);
    }

    public void paint() {
        System.out.println("Круг с радиусом - " + radius1);
    }
}
